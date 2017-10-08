/*
* Google Cloud Webhook Function
* 
* Author: Paul Hahn
* Project: Ticketbot
* Date: 10/06/2017
* 
* Funtions:
* - lookupEventNameLocationDate(name, location, date) //Returns a unique event
* - lookupEventReturnJSON(name, location, date)       //Returns a unique event in JSON format, for purchase funtion
* - lookupEventsInLocation(location)                  //Returns a list of events for a given location
* - purchaseTickets(numberOfTickets, eventObj)        //Purchase tickets given eventObj and numberOfTickets
*
*/


//'use strict';

const http = require('http');                                     // assign http module
const api_host = 'ticketbotai.azurewebsites.net';                 // api url

// export ticketbot module
exports.ticketbot = (req, res) => {

  // grab JSON parameters, context and metadata from API.AI call
  var intentName = req.body.result.metadata['intentName'];  
  var geo_city = encodeURIComponent(req.body.result.parameters['geo-city']);  
  var date = req.body.result.parameters['date'];                                 
  var numberOfTickets = req.body.result.parameters['number'];
  //var eventNameUserInput = req.body.result.parameters['Event_name'];   
  var eventNameInputEncoded = encodeURIComponent(req.body.result.parameters['Event_name']);

  var bookingDate = req.body.result.contexts[0].parameters['date']; 
  var bookingCity = encodeURIComponent(req.body.result.contexts[0].parameters['geo-city']);
  var citySearched = encodeURIComponent(req.body.result.contexts[1].parameters['geo-city']);
  //var eventContext = req.body.result.contexts[0].parameters['Event_name'];
  var bookingEventName = encodeURIComponent(req.body.result.contexts[0].parameters['Event_name']);
  
  
  console.log('intentName: ' + intentName);
  console.log('geo_city: ' + geo_city);
  console.log('date: ' + date);
  console.log('numberOfTickets: ' + numberOfTickets);
  //console.log('eventNameUserInput: ' + eventNameUserInput);
  console.log('eventNameInputEncoded: ' + eventNameInputEncoded);


  console.log('bookingDate: ' + bookingDate);
  console.log('bookingCity: ' + bookingCity);
  console.log('citySearched: ' + citySearched);
  //console.log('eventContext: ' + eventContext);
  console.log('bookingEventName: ' + bookingEventName);
  console.log('eventName: ' + bookingEventName);


  // global variables - event
  var eventId = "";
  var eventDate = "";
  var eventTime = "";
  var eventName = "";       
  var eventLocation = "";
  var eventVenue = "";
  var maxTickets = "";
  var ticketsAvailable = "";
  var minimumTickets = "";
  var ticketPrice = "";
  var description = "";

  // testing variables
  // const eName = "Halloween%20Fun";   <--------  RECENTLY COMMENTED OUT
  // const eCity = "Haddonfield";       <--------  RECENTLY COMMENTED OUT
  
  // switch statement with intentName as key 
  switch (intentName) {

    case "Tickets for a specific event":  
      if(date != ""){               
        //Lookup events with given Event Name, city and date
        lookupEventNameLocationDate(eventNameInputEncoded, geo_city, date).then((output) => {
          // Return the results of the API to API.AI
          res.setHeader('Content-Type', 'application/json'); 
          res.send(JSON.stringify({ "speech": output, "displayText": output}));
        }).catch((error) => {
          // If there is an error let the user know
          res.setHeader('Content-Type', 'application/json'); 
          res.send(JSON.stringify({ "speech": error, "displayText": error}));
        });
      } else {
        res.setHeader('Content-Type', 'application/json');
        res.send(JSON.stringify({ 
          "speech": 'sorry, we are encountering difficulty. please specify event and date you interested in[specific event]', 
          "displayText": 'sorry, we are encountering difficulty. please specify event and date you interested in[specific event]'
        }));
      } // end if
      break;

    case "Tickets for a specific event - number of tickets":

        //let date = req.body.result.contexts.parameters['date'];         // <--- this next!
        //eventName = eName;  <-------- RECENTLY COMMENTED OUT
        //geo_city = eCity;   <-------- RECENTLY COMMENTED OUT

        lookupEventReturnJSON(bookingEventName, bookingCity, bookingDate).then((eventObj) => {
          purchaseTickets(numberOfTickets, eventObj).then((output) => {
            // Return the results of the API to API.AI
            res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
            res.send(JSON.stringify({ "speech": output, "displayText": output}));
          }).catch((error) => {
            // If there is an error let the user know
            res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
            res.send(JSON.stringify({ "speech": error, "displayText": error}));
          }); // end purchaseTickets call
        }); // end lookupEventReturnJSON call
        break;

    case "Suggest events":
        echoFunction (date, intentName, numberOfTickets, location, "suggest events case").then((output) => {
          //callTicketbotApiBooking(numberOfTickets).then((output) => {
          // Return the results of the API to API.AI
          res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
          res.send(JSON.stringify({ "speech": output, "displayText": output}));
        }).catch((error) => {
          // If there is an error let the user know
          res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
          res.send(JSON.stringify({ "speech": error, "displayText": error}));
        });
        break;

    case "Suggest events - search by location":
        lookupEventsInLocation(geo_city).then((output) => {
          // Return the results of the API to API.AI
          res.setHeader('Content-Type', 'application/json'); 
          res.send(JSON.stringify({ "speech": output, "displayText": output}));
        }).catch((error) => {
        // If there is an error let the user know
          res.setHeader('Content-Type', 'application/json'); 
          res.send(JSON.stringify({ "speech": error, "displayText": error}));
        }); // end lookupEventsInLocation call
        break;

    // http://ticketbotai.azurewebsites.net/events/nameLocationDate?name=Halloween%20Fun&location=Haddonfield&date=2017-10-31
    case "Suggest events - search by location - choose event - yes":
        
        //eventName = eName;
        //geo_city = eCity;

        lookupEventReturnJSON(bookingEventName, citySearched, bookingDate).then((eventObj) => {
          purchaseTickets(numberOfTickets, eventObj).then((output) => {
            // Return the results of the API to API.AI
            res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
            res.send(JSON.stringify({ "speech": output, "displayText": output}));
          }).catch((error) => {
            // If there is an error let the user know
            res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
            res.send(JSON.stringify({ "speech": error, "displayText": error}));
          }); // end purchaseTickets call
        }); // end lookupEventReturnJSON call
      break;

    case "Suggest events - search by date":
        lookupEventsByDate(date).then((output) => {
          // Return the results of the API to API.AI
          res.setHeader('Content-Type', 'application/json'); 
          res.send(JSON.stringify({ "speech": output, "displayText": output}));
        }).catch((error) => {
        // If there is an error let the user know
          res.setHeader('Content-Type', 'application/json'); 
          res.send(JSON.stringify({ "speech": error, "displayText": error}));
        }); // end lookupEventsInLocation call
        break;

    // http://ticketbotai.azurewebsites.net/events/nameLocationDate?name=Halloween%20Fun&location=Haddonfield&date=2017-10-31
    case "Suggest events - search by date - choose event - yes":

        lookupEventReturnJSON(bookingEventName, bookingCity, bookingDate).then((eventObj) => {
          purchaseTickets(numberOfTickets, eventObj).then((output) => {
            // Return the results of the API to API.AI
            res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
            res.send(JSON.stringify({ "speech": output, "displayText": output}));
          }).catch((error) => {
            // If there is an error let the user know
            res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
            res.send(JSON.stringify({ "speech": error, "displayText": error}));
          }); // end purchaseTickets call
        }); // end lookupEventReturnJSON call
      break;



    case "X":
        echoFunction (date, intentName, numberOfTickets, city, "a message here").then((output) => {
          // Return the results of the API to API.AI
          res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
          res.send(JSON.stringify({ "speech": output, "displayText": output}));
        }).catch((error) => {
          // If there is an error let the user know
          res.setHeader('Content-Type', 'application/json'); //Requires application/json MIME type
          res.send(JSON.stringify({ "speech": error, "displayText": error}));
        });
        break;

    default:
        res.setHeader('Content-Type', 'application/json');
        res.send(JSON.stringify({ 
          "speech": 'sorry, we are encountering difficulty. no Intent match found', 
          "displayText": 'sorry, we are encountering difficulty. no Intent match found'                     
        })); // 
  } // end switch 

  


  // ADD COMMENT
  // http://ticketbotai.azurewebsites.net/events/nameLocationDate?name=Halloween%20Fun&location=Haddonfield&date=2017-10-31
  function lookupEventNameLocationDate(name, location, date) {
    return new Promise((resolve, reject) => {
      // Path for the HTTP GET request 
      let path = '/events/nameLocationDate' + '?name=' + name + '&location=' + location + '&date=' + date;   
      //let path = '/events/id' + '?id=1';                            //used for testing GET by event id
      console.log('GET Request within lookupEventNameLocationDate: ' + api_host + path);
      // Make the HTTP GET request to get the Ticketbot API
      http.get({host: api_host, path: path}, (res) => {
        let body = ' ';                         // local variable to store the response chunks
        res.on('data', (d) => { body += d; });  // store each response chunk
        res.on('end', () => {
          let parsedResponse = JSON.parse(body);
          let output = "";
          for (var i = 0; i < parsedResponse.length; i++) {           
            let event = parsedResponse[i];                               
            eventId = event.id;
            eventDate = event.date;
            eventTime = event.time;
            eventName = event.name;
            eventLocation = event.location;
            eventVenue = event.venue;
            maxTickets = event.maxTickets;
            ticketsAvailable = event.ticketsAvailable;
            minimumTickets = event.minimumTickets;
            ticketPrice = event.ticketPrice;
            description = event.description;
            console.log(eventId);
            console.log(eventDate);
            console.log(eventTime);
            console.log(eventName);
            console.log(eventLocation);
            console.log(eventVenue);
            console.log(maxTickets);
            console.log(ticketsAvailable);
            console.log(minimumTickets);
            console.log(ticketPrice);
            console.log(description);
          } // end for loop 

          // If tickets are available, prompt user for number of tickets
          if(ticketsAvailable>0){
              output =  " There are " + ticketsAvailable + " tickets available for" +
                " " + eventName + " at " + eventVenue +
                " on " + eventDate + " at " + eventTime + " ." +
                " The price per ticket is " + ticketPrice + " dollars." +
                " How many tickets would you like to purchase?";
          }else{
              output = "There are no seats.  Better luck next time!";
          }
          
          // Resolve the promise with the output text
          console.log('lookupEventNameLocationDate output: ' + output);
          resolve(output);
        });
        res.on('error', (error) => {
          reject(error);
        });
      }); // end get
    }); // end Promise
  } // end lookupEventNameLocationDate


  // Function to GET event data 
  // let path_plus_data = post_path + "?firstName=First&lastName=Last&eventID=" + eventId + "&numTickets=" + numberOfTickets;
  function lookupEventReturnJSON(name, location, date) {
    return new Promise((resolve, reject) => {

      // Path for the HTTP GET request 
      let path = '/events/nameLocationDate' + '?name=' + name + '&location=' + location + '&date=' + date; 
      //let path = '/events/date' + '?date=' + date;   
      //let path = '/events/id' + '?id=1';                            //used for testing GET by event id
      console.log('GET Request from lookupEventReturnJSON: ' + api_host + path);
      
      // Make the HTTP GET request to get the Ticketbot API
      http.get({host: api_host, path: path}, (res) => {
        let body = ' ';                         // local variable to store the response chunks
        res.on('data', (d) => { body += d; });  // store each response chunk
        res.on('end', () => {
          let parsedResponse = JSON.parse(body);
          let output = "";
          for (var i = 0; i < parsedResponse.length; i++) {           
            let event = parsedResponse[i];                               
            eventId = event.id;
            eventDate = event.date;
            eventTime = event.time;
            eventName = event.name;
            eventLocation = event.location;
            eventVenue = event.venue;
            maxTickets = event.maxTickets;
            ticketsAvailable = event.ticketsAvailable;
            minimumTickets = event.minimumTickets;
            ticketPrice = event.ticketPrice;
            description = event.description;
          } // end for loop
          var obj = {
            eventId: eventId,
            eventDate: eventDate,
            eventTime: eventTime,
            eventName: eventName,
            eventLocation: eventLocation,
            eventVenue: eventVenue,
            maxTickets: maxTickets,
            ticketsAvailable: ticketsAvailable,
            minimumTickets: minimumTickets,
            ticketPrice: ticketPrice,
            description: description
          };
          // Resolve the promise with the output text
          console.log('obj resolved within lookupEventReturnJSON: ' + obj);
          resolve(obj);
        });
        res.on('error', (error) => {
          reject(error);
        });
      }); // end get request
    }); // end Promise
  } // end lookupEventReturnJSON


  // Function to GET event data 
  // http://ticketbotai.azurewebsites.net/events/location?location={location}
  function lookupEventsInLocation(location) {
    return new Promise((resolve, reject) => {

      // Path for the HTTP GET request 
      let path = '/events/location' + '?location=' + location;   
      //let path = '/events/id' + '?id=1';                            //used for testing GET by event id
      
      console.log('GET Request within lookupEventsInLocation: ' + api_host + path);
      
      // Make the HTTP GET request to get the Ticketbot API
      http.get({host: api_host, path: path}, (res) => {
        let body = ' ';                         // local variable to store the response chunks
        res.on('data', (d) => { body += d; });  // store each response chunk
        res.on('end', () => {

          // After all the data has been received parse the JSON for desired data
          let parsedResponse = JSON.parse(body);                                                              
          let output="";
          if(parsedResponse.length > 0){
            output =  " There are tickets available in " + location + " for the following events: " ; 
            let numSuggestions = parsedResponse.length;
            if(parsedResponse.length >= 10){numSuggestions = 10;} 
            //if(parsedResponse.length < 10){numSuggestions = parsedResponse.length;} 
            for (var i = 0; i < numSuggestions; i++) {           
              let event = parsedResponse[i];                               
              eventId = event.id;
              eventDate = event.date;
              eventTime = event.time;
              eventName = event.name;
              eventLocation = event.location;
              eventVenue = event.venue;
              maxTickets = event.maxTickets;
              ticketsAvailable = event.ticketsAvailable;
              minimumTickets = event.minimumTickets;
              ticketPrice = event.ticketPrice;
              description = event.description;
              console.log(eventId);
              console.log(eventDate);
              console.log(eventTime);
              console.log(eventName);
              console.log(eventLocation);
              console.log(eventVenue);
              console.log(maxTickets);
              console.log(ticketsAvailable);
              console.log(minimumTickets);
              console.log(ticketPrice);
              console.log(description);
              output += eventName + " on " + eventDate + " .";
            } // end for loop
            output += " Which event are you interested in?" ;
          } else {
            output = "There are no events in " + location + ".  Better luck next time!";
          } // end if

          // Resolve the promise with the output text
          console.log('output from lookupEventsInLocation: ' + output);
          resolve(output);
        });
        res.on('error', (error) => {
          reject(error);
        });
      }); // end get
    }); // end Promise
  } // end lookupEventsInLocation


  // Function to GET event data 
  // http://ticketbotai.azurewebsites.net/events/location?location={location}
  function lookupEventsByDate(date) {
    return new Promise((resolve, reject) => {

      // Path for the HTTP GET request 
      let path = '/events/date' + '?date=' + date;   
      //let path = '/events/id' + '?id=1';                            //used for testing GET by event id
      
      console.log('GET Request within lookupEventsByDate: ' + api_host + path);
      
      // Make the HTTP GET request to get the Ticketbot API
      http.get({host: api_host, path: path}, (res) => {
        let body = ' ';                         // local variable to store the response chunks
        res.on('data', (d) => { body += d; });  // store each response chunk
        res.on('end', () => {

          // After all the data has been received parse the JSON for desired data
          let parsedResponse = JSON.parse(body);                                                              
          let output="";
          if(parsedResponse.length > 0){
            output =  " There are tickets available on " + date + " for the following events: " ; 
            let numSuggestions = parsedResponse.length;
            if(parsedResponse.length >= 10){numSuggestions = 10;} 
            //if(parsedResponse.length < 10){numSuggestions = parsedResponse.length;} 
            for (var i = 0; i < numSuggestions; i++) {           
              let event = parsedResponse[i];                               
              eventId = event.id;
              eventDate = event.date;
              eventTime = event.time;
              eventName = event.name;
              eventLocation = event.location;
              eventVenue = event.venue;
              maxTickets = event.maxTickets;
              ticketsAvailable = event.ticketsAvailable;
              minimumTickets = event.minimumTickets;
              ticketPrice = event.ticketPrice;
              description = event.description;
              console.log(eventId);
              console.log(eventDate);
              console.log(eventTime);
              console.log(eventName);
              console.log(eventLocation);
              console.log(eventVenue);
              console.log(maxTickets);
              console.log(ticketsAvailable);
              console.log(minimumTickets);
              console.log(ticketPrice);
              console.log(description);
              output += eventName + " in " + eventLocation + " .";
            } // end for loop
            output += " Which event are you interested in?" ;
          } else {
            output = "There are no events in "+ date + ".  Better luck next time!";
          } // end if

          // Resolve the promise with the output text
          console.log('output from lookupEventsByDate: ' + output);
          resolve(output);
        });
        res.on('error', (error) => {
          reject(error);
        });
      }); // end get
    }); // end Promise
  } // end lookupEventsByDate

  // Function to call Tickbot API and POST ticket purchase
  function purchaseTickets(numberOfTickets, eventObj){
    return  new Promise((resolve, reject) => {  
      let userEmail = "ticketbot@googlegroups.com";
      let post_path = '/sales/new';   // path to POST a sale
      let path_plus_data = post_path + 
          "?firstName=Paul" + 
          "&lastName=Hahn" +
          "&email=" + userEmail +
          "&eventID=" + eventObj.eventId +                                                 // eventId ... have to replace this hardcoded value!
          "&numTickets=" + numberOfTickets;
      console.log('POST Request from purchaseTickets here: ' + api_host + post_path);
      console.log('eventObj => id:' + eventObj.eventId + ' date:' + eventObj.eventDate + ' name:' + eventObj.eventName);
      var post_req  = null;
      var post_options = {
        host    : api_host,
        port    : '80',
        path    : path_plus_data,      
        method  : 'POST',
        headers : {
          'Content-Type': 'application/json',
          'Content-Length': 0                     
        }
      };

      let totalPrice = numberOfTickets * eventObj.ticketPrice + 1;

      // SOURCE OF DATA  
      // numberOfTickets passed as a parameter
      // user email set as a local variable
      // ticketsAvailable, eventName, eventDate, eventTime, eventVenue and eventLocation persisted for session
      let output = 
        "You have purchased " + numberOfTickets + " tickets to " + eventObj.eventName + " on " + eventObj.eventDate + 
        " at " + eventObj.eventTime + ". " + 
        " Final price, including a 1 dollar processing fee, is " + totalPrice + " dollars. " +
        "Your tickets will be emailed to " + userEmail + ". " +
        " Thank you for your purchase.  Goodbye." ; 
      console.log('final output: ' + output);
      resolve(output);

      post_req = http.request(post_options, function (res) {
        console.log('STATUS: ' + res.statusCode);
        console.log('HEADERS: ' + JSON.stringify(res.headers));
        res.setEncoding('utf8');
        res.on('data', function (chunk) {
          console.log('Response: ', chunk);
        });
      });

      post_req.on('error', function(e) {
        console.log('problem with request: ' + e.message);
      });

      post_req.end();
    }) // end Promise
  } // end purchaseTickets


  // TEST Function 
  function echoTestFunction(date, intentName, numberOfTickets, location, message) {
    return new Promise((resolve, reject) => {
      let output = "";
      output +=   " ECHO. " +
                  " numberOfTickets: " + numberOfTickets + 
                  " date: " + date +
                  " location: " + location +  
                  " intentName: " + intentName +
                  " Intent: " + message +
                  " ";
      console.log('output from echoFunction: ' + output);
      resolve(output);
    }); 
    res.on('error', (error) => {
      reject(error);
    });
  } // end echoFunction

}; // exports.ticketbot






    /* used to re-order date string before change to API
    /  let yyyy_mm_dd = date.split("-");
    /  let path = '/events/date' + '?date=' + yyyy_mm_dd[1] + '-' + yyyy_mm_dd[2] + '-' + yyyy_mm_dd[0]; 
    */


