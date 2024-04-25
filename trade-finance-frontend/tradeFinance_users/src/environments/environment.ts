export const environment = {
  production: true,

//LCs
  createApiUrl: 'http://192.168.137.1:8085',    //create LC
  getApiUrl: `http://192.137.149.240:8187`, //fetch applicant details
  getUrl: ` http://192.168.137.1:8085`,      //get all LCs details 
getlcNoUrl: 'http://192.168.137.1: 8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber} 
 putUrl: 'http://192.168.137.1:8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}



 //Documentary collections
  dcApiUrl: "http://192.168.0.1:9090",








// invoice discounting
 invUrl: 'http://192.168.91.141:9000' ,     //post invoice discounting forms
  

};