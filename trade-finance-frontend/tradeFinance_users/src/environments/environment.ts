export const environment = {
  production: true,

//LCs
  createApiUrl: 'http://192.168.90.30:8085',    //create LC
  getApiUrl: `http://192.168.90.30:8187`, //fetch applicant details
  getUrl: `http://192.168.90.30:8085`,      //get all LCs details
getlcNoUrl: 'http://192.168.90.30:8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber}
putUrl: 'http://192.168.90.30:8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}
transferApiUrl: 'http://192.168.90.30:8085', //Transfer LC


  dcApiUrl: "http://192.168.0.1:9090",
 apiUrl: 'http://192.168.70.290:8085',



 invUrl: 'https://your-backend-api.com/api'      //Replace with Inv.discounting Createform url
  
  
};