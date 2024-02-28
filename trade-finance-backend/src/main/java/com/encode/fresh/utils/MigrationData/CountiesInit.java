package com.encode.fresh.utils.MigrationData;//package co.ke.emtechhouse.es.utils.MigrationData;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CountiesInit {
//    public final CountyRepository countyRepository;
//    public final SubCountyRepository subCountyRepository;
//    public final CountiesJson countiesJson;
//
//    public CountiesInit(CountyRepository countyRepository, SubCountyRepository subCountyRepository, CountiesJson countiesJson) {
//        this.countyRepository = countyRepository;
//        this.subCountyRepository = subCountyRepository;
//        this.countiesJson = countiesJson;
//    }
//
//
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Data
//    public class Subcountydata{
//        public String name;
//    }
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @Data
//    public class Countydata{
//        public String name;
//        public String capital;
//        public Integer code;
//        public List<Subcountydata> sub_counties;
//    }
//
//    public void initCountiesData(){
//        List<County> counties = countiesJson.getAllCounties();
//        if (countyRepository.findAll().size() >= counties.size()){
//
//        }else{
//            counties.forEach(county -> {
//                County c =county;
//                c.setSubCounties(county.getSubCounties());
//                countyRepository.save(c);
//            });
////            countyRepository.saveAll(counties);
//        }
//    }
//}
