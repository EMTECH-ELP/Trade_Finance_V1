export const environment = {
  production: true,

//LCs
  createApiUrl: 'http://192.168.56.1:8085',    //create LC
  getApiUrl: `http://192.168.56.1:8187`, //fetch applicant details
  getAllUrl: `http://192.168.56.1:8085`,      //get all LCs details
getlcNoUrl: 'http://192.168.56.1:8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber}
putUrl: 'http://192.168.56.1:8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}
transferApiUrl: 'http://192.168.56.1:8085', //Transfer LC
getUrl: ` http://192.168.56.1:8085`,      //get all LCs details
 

 //Documentary collections
  dcApiUrl: "http://192.168.0.1:9090",


//bills
billApiUrl: 'http://192.168.56.1:8085', 
       // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}

approveLcApiUrl: 'http://192.168.56.1:8085' ,// Approval of a created LC
deleteLcApiUrl: 'http://192.168.56.1:8085',  //delete an already created LC



  authUrl: 'http://192.168.89.57:8082',
  resetUrl: '',

  // apiUrl: 'http://192.168.56.1:8085',
  // getApiUrl: 'http://192.168.91.98:8082',
  
 apiUrl: 'http://192.168.70.290:8085',





// invoice discounting
 invUrl: 'http://192.168.90.44:9000' ,     //post invoice discounting forms. Createform url
 saveUrl: 'http://192.168.91.141:9000',    // save repayment details form
 getInvUrl: 'http://192.168.91.96:9000',         // Fetch forms

};