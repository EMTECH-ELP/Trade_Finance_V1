export const environment = {
  production: true,

//LCs
  apiUrl: 'http://192.168.137.1:8085',    //create LC
  getApiUrl: `http://192.137.149.240:8187`, //fetch applicant details
  getUrl: ` http://192.168.137.1:8085`,      //get all LCs details 
getlcNoUrl: 'http://192.168.137.1: 8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber} 
//   getApiUrl: `http://192.168.137.1:8187`, //fetch applicant details
//   getUrl: `http://192.168.137.1:8085`,      //get all LCs details
// getlcNoUrl: 'http://192.168.137.1:8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber}
// putUrl: 'http://192.168.137.1:8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}




  authUrl: 'http://192.168.91.98:8082',
  resetUrl: '',

  // apiUrl: 'http://192.168.137.1:8085',
  // getApiUrl: 'http://192.168.91.98:8082',
  dcApiUrl: "http://192.168.0.1:9090",

// putUrl: ' http://192.168.137.1:v8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}
//   apiUrl: 'http://192.168.89.54:8085',    //create LC
//   getApiUrl: `http://192.168.89.54:8187`, //fetch applicant details
//   getUrl: `http://192.168.89.54:8085`,      //get all LCs details
// getlcNoUrl: 'http://192.168.89.54:8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber}
// putUrl: 'http://192.168.89.54:8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}



 

//   dcApiUrl: "http://192.168.0.1:9090",




// invoice discounting
 invUrl: 'http://192.168.91.141:9000' ,     //post invoice discounting forms. Createform url
 saveUrl: 'http://192.168.91.141:9000',  

};