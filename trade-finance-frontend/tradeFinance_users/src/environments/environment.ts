export const environment = {
  production: true,

//Authentication
authUrl: 'http://192.168.91.152:8080',
resetUrl: '',

//LCs
  createApiUrl: 'http://192.168.90.231:8085',    //create LC
  getApiUrl: `http://192.168.88.33:8187`, //fetch applicant details
  getAllUrl: `http://192.168.90.231:8085`,      //get all LCs details
getlcNoUrl: 'http://192.168.90.231:8085',    //fetch Lc details by lcNumber            (enviroment.getlcNoUrl)/api/v1/LC/lcNumber/{lcNumber}
putUrl: 'http://192.168.90.231:8085',        // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}
transferApiUrl: 'http://192.168.90.231:8085', //Transfer LC
getUrl: ` http://192.168.90.231:8085`,      //get all LCs details
approveLcApiUrl: 'http://192.168.90.231:8085' ,// Approval of a created LC
deleteLcApiUrl: 'http://192.168.90.231:8085',  //delete an already created LC
generateMtUrl: 'http://192.168.90.231:8085',           //generate LC MT message

//Shipment terms
shipmentTermsApi: 'http://192.168.89.92:8085',      //fetch all shipment terms


 //Documentary collections
  dcApiUrl: "http://192.168.0.1:9090",


//bills
billApiUrl: 'http://192.168.88.101:8085', 
       // Modify LC details fetched by LcNumber  (enviroment.putUrl)/api/v1/LC/lcNumber/{lcNumber}


// invoice discounting

 invUrl: 'http://192.168.89.121:8085' ,     //fETCH &  post invoice discounting forms. Createform url
 getCountry_CityUrl: 'http://192.168.88.33:8187',  //Dropdowncountries

 saveUrl: 'http://192.168.91.141:9000',    // save repayment details form
 uploadUrl: '',                             //Upload Documents


 //bank gurantee url
bgUrl: 'http://192.168.91.61:8085',

};