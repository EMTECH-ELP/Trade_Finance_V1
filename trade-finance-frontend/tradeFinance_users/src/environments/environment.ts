export const environment = {
  production: true,

//LCs
  apiUrl: 'http://192.168.89.54:8085',    //create LC
  getApiUrl: `http://192.168.89.54:8187`, //fetch applicant details
  getUrl: `http://192.168.89.54:8085`,      //get all LCs details
getlcNoUrl: 'http://192.168.89.54:8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber}
putUrl: 'http://192.168.89.54:8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}



  dcApiUrl: "http://192.168.0.1:9090",



 invUrl: 'https://your-backend-api.com/api'      //Replace with Inv.discounting Createform url
  
  
};