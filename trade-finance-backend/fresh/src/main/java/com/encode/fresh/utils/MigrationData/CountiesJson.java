package com.encode.fresh.utils.MigrationData;//package co.ke.emtechhouse.es.utils.MigrationData;
//
//import com.google.gson.Gson;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//
//@Service
//public class CountiesJson {
//
//    public List<County> getAllCounties(){
//        List<County> counties = new ArrayList<>();
//        String countiesstr = "{ \"allcounties\": [\n" +
//                "  {\n" +
//                "    \"countyName\": \"BARINGO\",\n" +
//                "    \"countyCapital\": \"KABARNET\",\n" +
//                "    \"countyCode\": 30,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BARINGO CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"BARINGO NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"BARINGO SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"ELDAMA RAVINE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MOGOTIO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"TIATY\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"BOMET\",\n" +
//                "    \"countyCapital\": \"BOMET\",\n" +
//                "    \"countyCode\": 36,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BOMET CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"BOMET EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"CHEPALUNGU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KONOIN\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"SOTIK\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"BUNGOMA\",\n" +
//                "    \"countyCapital\": \"BUNGOMA\",\n" +
//                "    \"countyCode\": 39,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BUMULA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KABUCHAI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KANDUYI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KIMILIL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MT ELGON\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"SIRISIA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"TONGAREN\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"WEBUYE EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"WEBUYE WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"BUSIA\",\n" +
//                "    \"countyCapital\": \"BUSIA\",\n" +
//                "    \"countyCode\": 40,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BUDALANGI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"BUTULA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"FUNYULA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"NAMBELE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"TESO SOUTH\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"ELGEYO-MARAKWET\",\n" +
//                "    \"countyCapital\": \"ITEN\",\n" +
//                "    \"countyCode\": 28,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KEIYO NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KEIYO SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MARAKWET EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MARAKWET WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"EMBU\",\n" +
//                "    \"countyCapital\": \"EMBU\",\n" +
//                "    \"countyCode\": 14,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"MANYATTA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"MBEERE NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MBEERE SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"RUNYENJES\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"GARISSA\",\n" +
//                "    \"countyCapital\": \"GARISSA\",\n" +
//                "    \"countyCode\": 7,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"DAADAB\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"FAFI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"GARISSA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"HULUGHO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"IJARA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"LAGDERA BALAMBALA\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"HOMA BAY\",\n" +
//                "    \"countyCapital\": \"HOMA BAY\",\n" +
//                "    \"countyCode\": 43,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"HOMABAY TOWN\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KABONDO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KARACHWONYO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KASIPUL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MBITA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"NDHIWA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"RANGWE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"SUBA\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"ISIOLO\",\n" +
//                "    \"countyCapital\": \"ISIOLO\",\n" +
//                "    \"countyCode\": 11,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"ISIOLO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"GARBA TULA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MERIT\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KAJIADO\",\n" +
//                "    \"countyCode\": 34,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"ISINYA.\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KAJIADO CENTRAL.\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KAJIADO NORTH.\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"LOITOKITOK.\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MASHUURU.\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KAKAMEGA\",\n" +
//                "    \"countyCapital\": \"KAKAMEGA\",\n" +
//                "    \"countyCode\": 37,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BUTERE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KAKAMEGA CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KAKAMEGA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KAKAMEGA NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"KAKAMEGA SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"KHWISERO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"LUGARI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"LUKUYANI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"LURAMBI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 10,\n" +
//                "        \"subCountyName\": \"MATETE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 11,\n" +
//                "        \"subCountyName\": \"MUMIAS\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 12,\n" +
//                "        \"subCountyName\": \"MUTUNGU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 13,\n" +
//                "        \"subCountyName\": \"NAVAKHOLO\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KERICHO\",\n" +
//                "    \"countyCapital\": \"KERICHO\",\n" +
//                "    \"countyCode\": 35,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"AINAMOI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"BELGUT\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"BURETI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KIPKELION EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"KIPKELION WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"SOIN SIGOWET\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KIAMBU\",\n" +
//                "    \"countyCapital\": \"KIAMBU\",\n" +
//                "    \"countyCode\": 22,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"GATUNDU NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"GATUNDU SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"GITHUNGURI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"JUJA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"KABETE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"KIAMBAA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"KIAMBU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"KIKUYU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"LIMURU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 10,\n" +
//                "        \"subCountyName\": \"RUIRU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 11,\n" +
//                "        \"subCountyName\": \"THIKA TOWN\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 12,\n" +
//                "        \"subCountyName\": \"LARI\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KILIFI\",\n" +
//                "    \"countyCapital\": \"KILIFI\",\n" +
//                "    \"countyCode\": 3,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"GANZE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KALOLENI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KILIFI NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KILIFI SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MAGARINI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"MALINDI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"RABAI\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KIRINYAGA\",\n" +
//                "    \"countyCapital\": \"KERUGOYA/KUTUS\",\n" +
//                "    \"countyCode\": 20,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KIRINYAGA CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KIRINYAGA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KIRINYAGA WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MWEA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MWEA WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KISII\",\n" +
//                "    \"countyCapital\": \"KISII\",\n" +
//                "    \"countyCode\": 45,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KITUTU CHACHE NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KITUTU CHACHE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"NYARIBARI MASABA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"NYARIBARI CHACHE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"BOMACHOGE BORABU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"BOMACHOGE CHACHE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"BOBASI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"SOUTH MUGIRANGO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"BONCHARI\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KISUMU\",\n" +
//                "    \"countyCapital\": \"KISUMU\",\n" +
//                "    \"countyCode\": 42,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KISUMU CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KISUMU EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KISUMU WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MOHORONI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"NYAKACH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"NYANDO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"SEME\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KITUI\",\n" +
//                "    \"countyCapital\": \"KITUI\",\n" +
//                "    \"countyCode\": 15,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"IKUTHA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KATULANI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KISASI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KITUI CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"KITUI WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"LOWER YATTA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"MATIYANI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"MIGWANI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"MUTITU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 10,\n" +
//                "        \"subCountyName\": \"MUTOMO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 11,\n" +
//                "        \"subCountyName\": \"MUUMONIKYUSU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 12,\n" +
//                "        \"subCountyName\": \"MWINGI CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 13,\n" +
//                "        \"subCountyName\": \"MWINGI EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 14,\n" +
//                "        \"subCountyName\": \"NZAMBANI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 15,\n" +
//                "        \"subCountyName\": \"TSEIKURU\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"KWALE\",\n" +
//                "    \"countyCapital\": \"KWALE\",\n" +
//                "    \"countyCode\": 2,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KINANGO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"LUNGALUNGA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MSAMBWENI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MUTUGA\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"LAIKIPIA\",\n" +
//                "    \"countyCapital\": \"RUMURUTI\",\n" +
//                "    \"countyCode\": 31,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"LAIKIPIA CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"LAIKIPIA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"LAIKIPIA NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"LAIKIPIA WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"NYAHURURU\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"LAMU\",\n" +
//                "    \"countyCapital\": \"LAMU\",\n" +
//                "    \"countyCode\": 5,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"LAMU EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"LAMU WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"MACHAKOS\",\n" +
//                "    \"countyCapital\": \"MACHAKOS\",\n" +
//                "    \"countyCode\": 16,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KATHIANI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"MACHAKOS TOWN\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MASINGA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MATUNGULU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MAVOKO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"MWALA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"YATTA\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"MAKUENI\",\n" +
//                "    \"countyCapital\": \"WOTE\",\n" +
//                "    \"countyCode\": 17,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KAITI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KIBWEI WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KIBWEZI EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KILOME\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MAKUENI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"MBOONI\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"MANDERA\",\n" +
//                "    \"countyCapital\": \"MANDERA\",\n" +
//                "    \"countyCode\": 9,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BANISSA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"LAFEY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MANDERA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MANDERA NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MANDERA SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"MANDERA WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"MARSABIT\",\n" +
//                "    \"countyCapital\": \"MARSABIT\",\n" +
//                "    \"countyCode\": 10,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"LAISAMIS\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"MOYALE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"NORTH HOR\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"SAKU\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"MERU\",\n" +
//                "    \"countyCapital\": \"MERU\",\n" +
//                "    \"countyCode\": 12,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BUURI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"IGEMBE CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"IGEMBE NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"IGEMBE SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"IMENTI CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"IMENTI NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"IMENTI SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"TIGANIA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"TIGANIA WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"MIGORI\",\n" +
//                "    \"countyCapital\": \"MIGORI\",\n" +
//                "    \"countyCode\": 44,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"AWENDO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KURIA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KURIA WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MABERA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"NTIMARU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"RONGO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"SUNA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"SUNA WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"URIRI\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"MOMBASA\",\n" +
//                "    \"countyCapital\": \"MOMBASA CITY\",\n" +
//                "    \"countyCode\": 1,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"CHANGAMWE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"JOMVU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KISAUNI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"LIKONI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MVITA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"NYALI\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"MURANG'A\",\n" +
//                "    \"countyCapital\": \"MURANG'A\",\n" +
//                "    \"countyCode\": 21,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"GATANGA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KAHURO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KANDARA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KANGEMA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"KIGUMO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"KIHARU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"MATHIOYA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"MURANG’A SOUTH\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"NAIROBI\",\n" +
//                "    \"countyCapital\": \"NAIROBI CITY\",\n" +
//                "    \"countyCode\": 47,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"DAGORETTI NORTH SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"DAGORETTI SOUTH SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"EMBAKASI CENTRAL SUB COUNT\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"EMBAKASI EAST SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"EMBAKASI NORTH SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"EMBAKASI SOUTH SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"EMBAKASI WEST SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"KAMUKUNJI SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"KASARANI SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 10,\n" +
//                "        \"subCountyName\": \"KIBRA SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 11,\n" +
//                "        \"subCountyName\": \"LANG'ATA SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 12,\n" +
//                "        \"subCountyName\": \"MAKADARA SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 13,\n" +
//                "        \"subCountyName\": \"MATHARE SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 14,\n" +
//                "        \"subCountyName\": \"ROYSAMBU SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 15,\n" +
//                "        \"subCountyName\": \"RUARAKA SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 16,\n" +
//                "        \"subCountyName\": \"STAREHE SUB COUNTY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 17,\n" +
//                "        \"subCountyName\": \"WESTLANDS SUB COUNTY\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"NAKURU\",\n" +
//                "    \"countyCapital\": \"NAKURU\",\n" +
//                "    \"countyCode\": 32,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BAHATI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"GILGIL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KURESOI NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KURESOI SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MOLO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"NAIVASHA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"NAKURU TOWN EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"NAKURU TOWN WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 9,\n" +
//                "        \"subCountyName\": \"NJORO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 10,\n" +
//                "        \"subCountyName\": \"RONGAI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 11,\n" +
//                "        \"subCountyName\": \"SUBUKIA\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"NANDI\",\n" +
//                "    \"countyCapital\": \"KAPSABET\",\n" +
//                "    \"countyCode\": 29,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"ALDAI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"CHESUMEI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"EMGWEN\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MOSOP\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"NANDI HILLS\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"TINDIRET\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"NAROK\",\n" +
//                "    \"countyCapital\": \"NAROK\",\n" +
//                "    \"countyCode\": 33,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"NAROK EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"NAROK NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"NAROK SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"NAROK WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"TRANSMARA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"TRANSMARA WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"NYAMIRA\",\n" +
//                "    \"countyCapital\": \"NYAMIRA\",\n" +
//                "    \"countyCode\": 46,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BORABU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"MANGA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MASABA NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"NYAMIRA NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"NYAMIRA SOUTH\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"NYANDARUA\",\n" +
//                "    \"countyCapital\": \"OL KALOU\",\n" +
//                "    \"countyCode\": 18,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KINANGOP\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KIPIPIRI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"NDARAGWA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"OL KALOU\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"OL JORO OROK\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"NYERI\",\n" +
//                "    \"countyCapital\": \"NYERI\",\n" +
//                "    \"countyCode\": 19,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"KIENI EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KIENI WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MATHIRA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MATHIRA WEST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"MuKURWENI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"NYERI TOWN\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 7,\n" +
//                "        \"subCountyName\": \"OTHAYA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 8,\n" +
//                "        \"subCountyName\": \"TETU\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"SAMBURU\",\n" +
//                "    \"countyCapital\": \"MARALAL\",\n" +
//                "    \"countyCode\": 25,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"SAMBURU EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"SAMBURU NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"SAMBURU WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"SIAYA\",\n" +
//                "    \"countyCapital\": \"SIAYA\",\n" +
//                "    \"countyCode\": 41,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"ALEGO USONGA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"BONDO\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"GEM\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"RARIEDA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"UGENYA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"UNGUJA\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"TAITA-TAVETA\",\n" +
//                "    \"countyCapital\": \"VOI\",\n" +
//                "    \"countyCode\": 6,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"MWATATE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"TAVETA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"VOI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"WUNDANYI\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"TANA RIVER\",\n" +
//                "    \"countyCapital\": \"HOLA\",\n" +
//                "    \"countyCode\": 4,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"BURA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"GALOLE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"GARSEN\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"THARAKA-NITHI\",\n" +
//                "    \"countyCapital\": \"CHUKA\",\n" +
//                "    \"countyCode\": 13,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"CHUKA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"IGAMBANGOBE\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"MAARA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MUTHAMBI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"THARAKA NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"THARAKA SOUTH\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"TRANS-NZOIA\",\n" +
//                "    \"countyCapital\": \"KITALE\",\n" +
//                "    \"countyCode\": 26,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"CHERANGANY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"ENDEBESS\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KIMININI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"KWANZA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"SABOTI\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"TURKANA\",\n" +
//                "    \"countyCapital\": \"LODWAR\",\n" +
//                "    \"countyCode\": 23,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"LOIMA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"TURKANA CENTRAL\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"TURKANA EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"TURKANA NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"TURKANA SOUTH\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"UASIN GISHU\",\n" +
//                "    \"countyCapital\": \"ELDORET\",\n" +
//                "    \"countyCode\": 27,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"AINABKOI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"KAPSERET\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"KESSES\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"MOIBEN\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"SOY\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"TURBO\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"VIHIGA\",\n" +
//                "    \"countyCapital\": \"VIHIGA\",\n" +
//                "    \"countyCode\": 38,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"EMUHAYA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"HAMISI\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"LUANDA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"SABATIA\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"VIHIGA\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"WAJIR\",\n" +
//                "    \"countyCapital\": \"WAJIR\",\n" +
//                "    \"countyCode\": 8,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"ELDAS\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"TARBAJ\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"WAJIR EAST\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"WAJIR NORTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 5,\n" +
//                "        \"subCountyName\": \"WAJIR SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 6,\n" +
//                "        \"subCountyName\": \"WAJIR WEST\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"countyName\": \"WEST POKOT\",\n" +
//                "    \"countyCapital\": \"KAPENGURIA\",\n" +
//                "    \"countyCode\": 24,\n" +
//                "    \"subCounties\": [\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 1,\n" +
//                "        \"subCountyName\": \"CENTRAL POKOT\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 2,\n" +
//                "        \"subCountyName\": \"NORTH POKOT\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 3,\n" +
//                "        \"subCountyName\": \"POKOT SOUTH\"\n" +
//                "      },\n" +
//                "      {\n" +
//                "        \"subCountyCode\": 4,\n" +
//                "        \"subCountyName\": \"WEST POKOT\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  }\n" +
//                "]}";
//        JSONObject jo = new JSONObject(countiesstr);
//        JSONArray ja = jo.getJSONArray("allcounties");
//        for (Object obj : ja) {
//            JSONObject jo2 = new JSONObject(obj.toString());
//            County county = new Gson().fromJson(jo2.toString(),County.class);
//            counties.add(county);
//        }
//        return counties;
//    }
//
//}
