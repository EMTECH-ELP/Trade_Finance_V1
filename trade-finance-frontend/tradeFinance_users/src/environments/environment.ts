export const environment = {
  production: true,

  // apiUrl: "http://52.15.152.26:9051",
  // baseUrl: "http://52.15.152.26:9051",
  // serverAPI: "http://52.15.152.26:9051",
  // AUTH_URL: "http://52.15.152.26:9051",
  // uraUrl: "http://52.15.152.26:9051",
  // authUrl: "http://52.15.152.26:9051",

  // baseUrl: "http://52.15.152.26:1905",

  // baseUrl: "http://127.0.0.1:9090",

//LCs
  apiUrl: 'http://192.168.137.1:8085',    //create LC
  getApiUrl: `http://192.137.149.240:8187`, //fetch applicant details
  getUrl: `http://192.168.137.1:8085`,      //get all LCs details
getlcNoUrl: 'http://192.168.137.1: 8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber}

putUrl: 'http://192.168.137.1:v8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}

 invUrl: 'https://your-backend-api.com/api'      //Replace with Inv.discounting Createform url
  
  
};