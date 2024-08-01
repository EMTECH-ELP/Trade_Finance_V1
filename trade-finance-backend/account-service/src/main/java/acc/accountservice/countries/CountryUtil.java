package acc.accountservice.countries;

import java.util.HashMap;
import java.util.Map;

public class CountryUtil {
    private static final Map<String, String> CAPITAL_CITY_MAP = new HashMap<>();

    static {
        // Initialize the map with country codes and their capitals
        CAPITAL_CITY_MAP.put("AF", "Kabul");
        CAPITAL_CITY_MAP.put("AL", "Tirana");
        CAPITAL_CITY_MAP.put("DZ", "Algiers");
        CAPITAL_CITY_MAP.put("AS", "Pago Pago"); // American Samoa
        CAPITAL_CITY_MAP.put("AD", "Andorra la Vella");
        CAPITAL_CITY_MAP.put("AO", "Luanda");
        CAPITAL_CITY_MAP.put("AI", "The Valley");
        CAPITAL_CITY_MAP.put("AQ", "Longyearbyen"); // Svalbard
        CAPITAL_CITY_MAP.put("AG", "Saint George's");
        CAPITAL_CITY_MAP.put("AR", "Buenos Aires");
        CAPITAL_CITY_MAP.put("AM", "Yerevan");
        CAPITAL_CITY_MAP.put("AW", "Oranjestad");
        CAPITAL_CITY_MAP.put("AC", "Saint Pierre"); // Saint Pierre and Miquelon
        CAPITAL_CITY_MAP.put("AZ", "Baku");
        CAPITAL_CITY_MAP.put("BS", "Nassau");
        CAPITAL_CITY_MAP.put("BH", "Manama");
        CAPITAL_CITY_MAP.put("BD", "Dhaka");
        CAPITAL_CITY_MAP.put("BB", "Bridgetown");
        CAPITAL_CITY_MAP.put("BY", "Minsk");
        CAPITAL_CITY_MAP.put("BE", "Brussels");
        CAPITAL_CITY_MAP.put("BZ", "Belmopan");
        CAPITAL_CITY_MAP.put("BJ", "Porto-Novo");
        CAPITAL_CITY_MAP.put("BT", "Thimphu");
        CAPITAL_CITY_MAP.put("BO", "La Paz");
        CAPITAL_CITY_MAP.put("BA", "Sarajevo");
        CAPITAL_CITY_MAP.put("BW", "Gaborone");
        CAPITAL_CITY_MAP.put("BR", "Brasília");
        CAPITAL_CITY_MAP.put("BN", "Bandar Seri Begawan");
        CAPITAL_CITY_MAP.put("BG", "Sofia");
        CAPITAL_CITY_MAP.put("BF", "Ouagadougou");
        CAPITAL_CITY_MAP.put("BI", "Bujumbura");
        CAPITAL_CITY_MAP.put("KH", "Phnom Penh");
        CAPITAL_CITY_MAP.put("CM", "Yaoundé");
        CAPITAL_CITY_MAP.put("CA", "Ottawa");
        CAPITAL_CITY_MAP.put("CF", "Bangui");
        CAPITAL_CITY_MAP.put("TD", "N'Djamena");
        CAPITAL_CITY_MAP.put("CL", "Santiago");
        CAPITAL_CITY_MAP.put("CN", "Beijing");
        CAPITAL_CITY_MAP.put("CO", "Bogotá");
        CAPITAL_CITY_MAP.put("KM", "Saint-Denis");
        CAPITAL_CITY_MAP.put("CG", "Kinshasa");
        CAPITAL_CITY_MAP.put("CD", "Kinshasa");
        CAPITAL_CITY_MAP.put("CI", "Abidjan");
        CAPITAL_CITY_MAP.put("HR", "Zagreb");
        CAPITAL_CITY_MAP.put("CU", "Havana");
        CAPITAL_CITY_MAP.put("CY", "Nicosia");
        CAPITAL_CITY_MAP.put("CZ", "Prague");
        CAPITAL_CITY_MAP.put("DK", "Copenhagen");
        CAPITAL_CITY_MAP.put("DJ", "Djibouti");
        CAPITAL_CITY_MAP.put("DM", "Roseau");
        CAPITAL_CITY_MAP.put("DO", "Santo Domingo");
        CAPITAL_CITY_MAP.put("EC", "Quito");
        CAPITAL_CITY_MAP.put("EG", "Cairo");
        CAPITAL_CITY_MAP.put("SV", "San Salvador");
        CAPITAL_CITY_MAP.put("GQ", "Malabo");
        CAPITAL_CITY_MAP.put("ER", "Asmara");
        CAPITAL_CITY_MAP.put("EE", "Tallinn");
        CAPITAL_CITY_MAP.put("SZ", "Mbabane");
        CAPITAL_CITY_MAP.put("ET", "Addis Ababa");
        CAPITAL_CITY_MAP.put("FK", "Stanley"); // Falkland Islands
        CAPITAL_CITY_MAP.put("FO", "Tórshavn"); // Faroe Islands
        CAPITAL_CITY_MAP.put("GF", "Cayenne"); // French Guiana
        CAPITAL_CITY_MAP.put("TF", "Paris"); // French Southern Territories
        CAPITAL_CITY_MAP.put("GA", "Libreville");
        CAPITAL_CITY_MAP.put("GM", "Banjul");
        CAPITAL_CITY_MAP.put("GE", "Tbilisi");
        CAPITAL_CITY_MAP.put("GH", "Accra");
        CAPITAL_CITY_MAP.put("GI", "Gibraltar");
        CAPITAL_CITY_MAP.put("GL", "Nuuk");
        CAPITAL_CITY_MAP.put("GD", "Kingstown");
        CAPITAL_CITY_MAP.put("GP", "Basse-Terre"); // Guadeloupe
        CAPITAL_CITY_MAP.put("GU", "Hagåtña");
        CAPITAL_CITY_MAP.put("GT", "Guatemala City");
        CAPITAL_CITY_MAP.put("GY", "Georgetown");
        CAPITAL_CITY_MAP.put("HT", "Port-au-Prince");
        CAPITAL_CITY_MAP.put("HM", "Hamilton"); // Bermuda
        CAPITAL_CITY_MAP.put("VA", "Vatican City");
        CAPITAL_CITY_MAP.put("HN", "Tegucigalpa");
        CAPITAL_CITY_MAP.put("HU", "Budapest");
        CAPITAL_CITY_MAP.put("IS", "Reykjavík");
        CAPITAL_CITY_MAP.put("IN", "New Delhi");
        CAPITAL_CITY_MAP.put("ID", "Jakarta");
        CAPITAL_CITY_MAP.put("IR", "Tehran");
        CAPITAL_CITY_MAP.put("IQ", "Baghdad");
        CAPITAL_CITY_MAP.put("IE", "Dublin");
        CAPITAL_CITY_MAP.put("IL", "Jerusalem");
        CAPITAL_CITY_MAP.put("IT", "Rome");
        CAPITAL_CITY_MAP.put("JM", "Kingston");
        CAPITAL_CITY_MAP.put("JP", "Tokyo");
        CAPITAL_CITY_MAP.put("JO", "Amman");
        CAPITAL_CITY_MAP.put("KZ", "Nur-Sultan");
        CAPITAL_CITY_MAP.put("KE", "Nairobi");
        CAPITAL_CITY_MAP.put("KI", "Tarawa");
        CAPITAL_CITY_MAP.put("KP", "Pyongyang");
        CAPITAL_CITY_MAP.put("KR", "Seoul");
        CAPITAL_CITY_MAP.put("KW", "Kuwait City");
        CAPITAL_CITY_MAP.put("KG", "Bishkek");
        CAPITAL_CITY_MAP.put("LA", "Vientiane");
        CAPITAL_CITY_MAP.put("LV", "Riga");
        CAPITAL_CITY_MAP.put("LB", "Beirut");
        CAPITAL_CITY_MAP.put("LS", "Maseru");
        CAPITAL_CITY_MAP.put("LR", "Monrovia");
        CAPITAL_CITY_MAP.put("LY", "Tripoli");
        CAPITAL_CITY_MAP.put("LI", "Vaduz");
        CAPITAL_CITY_MAP.put("LT", "Vilnius");
        CAPITAL_CITY_MAP.put("LU", "Luxembourg");
        CAPITAL_CITY_MAP.put("MG", "Antananarivo");
        CAPITAL_CITY_MAP.put("MW", "Lilongwe");
        CAPITAL_CITY_MAP.put("YT", "Mamoudzou"); // Mayotte
        CAPITAL_CITY_MAP.put("MY", "Kuala Lumpur");
        CAPITAL_CITY_MAP.put("MV", "Male");
        CAPITAL_CITY_MAP.put("ML", "Bamako");
        CAPITAL_CITY_MAP.put("MT", "Valletta");
        CAPITAL_CITY_MAP.put("MH", "Palikir"); // Marshall Islands
        CAPITAL_CITY_MAP.put("MQ", "Fort-de-France"); // Martinique
        CAPITAL_CITY_MAP.put("MR", "Nouakchott");
        CAPITAL_CITY_MAP.put("MU", "Port Louis");
        CAPITAL_CITY_MAP.put("MX", "Mexico City");
        CAPITAL_CITY_MAP.put("FM", "Koror"); // Federated States of Micronesia
        CAPITAL_CITY_MAP.put("MD", "Chișinău");
        CAPITAL_CITY_MAP.put("MC", "Monaco");
        CAPITAL_CITY_MAP.put("MN", "Ulaanbaatar");
        CAPITAL_CITY_MAP.put("ME", "Podgorica");
        CAPITAL_CITY_MAP.put("MA", "Rabat");
        CAPITAL_CITY_MAP.put("MZ", "Maputo");
        CAPITAL_CITY_MAP.put("MM", "Yangon");
        CAPITAL_CITY_MAP.put("NA", "Windhoek");
        CAPITAL_CITY_MAP.put("NR", "Yaren"); // Nauru
        CAPITAL_CITY_MAP.put("NP", "Kathmandu");
        CAPITAL_CITY_MAP.put("NL", "Amsterdam");
        CAPITAL_CITY_MAP.put("NZ", "Wellington");
        CAPITAL_CITY_MAP.put("NI", "Managua");
        CAPITAL_CITY_MAP.put("NE", "Niamey");
        CAPITAL_CITY_MAP.put("NG", "Abuja");
        CAPITAL_CITY_MAP.put("NU", "Alofi"); // Niue
        CAPITAL_CITY_MAP.put("NF", "Kingston"); // Norfolk Island
        CAPITAL_CITY_MAP.put("MP", "Saipan"); // Northern Mariana Islands
        CAPITAL_CITY_MAP.put("NO", "Oslo");
        CAPITAL_CITY_MAP.put("OM", "Muscat");
        CAPITAL_CITY_MAP.put("PK", "Islamabad");
        CAPITAL_CITY_MAP.put("PW", "Melekeok"); // Palau
        CAPITAL_CITY_MAP.put("PA", "Panama City");
        CAPITAL_CITY_MAP.put("PG", "Port Moresby");
        CAPITAL_CITY_MAP.put("PY", "Asunción");
        CAPITAL_CITY_MAP.put("PE", "Lima");
        CAPITAL_CITY_MAP.put("PH", "Manila");
        CAPITAL_CITY_MAP.put("PL", "Warsaw");
        CAPITAL_CITY_MAP.put("PT", "Lisbon");
        CAPITAL_CITY_MAP.put("PR", "San Juan"); // Puerto Rico
        CAPITAL_CITY_MAP.put("QA", "Doha");
        CAPITAL_CITY_MAP.put("RO", "Bucharest");
        CAPITAL_CITY_MAP.put("RU", "Moscow");
        CAPITAL_CITY_MAP.put("RW", "Kigali");
        CAPITAL_CITY_MAP.put("BL", "Saint-Pierre"); // Saint Barthélemy
        CAPITAL_CITY_MAP.put("KN", "Basseterre"); // Saint Kitts and Nevis
        CAPITAL_CITY_MAP.put("LC", "Castries"); // Saint Lucia
        CAPITAL_CITY_MAP.put("MF", "Marie-Galante"); // Saint Martin
        CAPITAL_CITY_MAP.put("PM", "Marie-Hélène"); // Saint Pierre and Miquelon
        CAPITAL_CITY_MAP.put("VC", "Kingstown"); // Saint Vincent and the Grenadines
        CAPITAL_CITY_MAP.put("SM", "San Marino");
        CAPITAL_CITY_MAP.put("ST", "Dili"); // East Timor (Timor-Leste)
        CAPITAL_CITY_MAP.put("SA", "Riyadh");
        CAPITAL_CITY_MAP.put("SN", "Dakar");
        CAPITAL_CITY_MAP.put("RS", "Belgrade");
        CAPITAL_CITY_MAP.put("SC", "Victoria");
        CAPITAL_CITY_MAP.put("SL", "Freetown");
        CAPITAL_CITY_MAP.put("SG", "Singapore");
        CAPITAL_CITY_MAP.put("SK", "Bratislava");
        CAPITAL_CITY_MAP.put("SI", "Ljubljana");
        CAPITAL_CITY_MAP.put("SB", "Honiara"); // Solomon Islands
        CAPITAL_CITY_MAP.put("AE", "Abu Dhabi"); // United Arab Emirates
        CAPITAL_CITY_MAP.put("AN", "Willemstad"); // Netherlands Antilles
        CAPITAL_CITY_MAP.put("AT", "Vienna"); // Austria
        CAPITAL_CITY_MAP.put("AU", "Canberra"); // Australia
        CAPITAL_CITY_MAP.put("AX", "Mariehamn"); // Åland Islands
        CAPITAL_CITY_MAP.put("BM", "Hamilton"); // Bermuda
        CAPITAL_CITY_MAP.put("MM", "Naypyidaw"); // Burma
        CAPITAL_CITY_MAP.put("BV", "No claim"); // Bouvet Island
        CAPITAL_CITY_MAP.put("CC", "West Island"); // Cocos (Keeling) Islands
        CAPITAL_CITY_MAP.put("CH", "Bern"); // Switzerland
        CAPITAL_CITY_MAP.put("CK", "Avarua"); // Cook Islands
        CAPITAL_CITY_MAP.put("CP", "No claim"); // Clipperton Island
        CAPITAL_CITY_MAP.put("CR", "San José"); // Costa Rica
        CAPITAL_CITY_MAP.put("CS", "Podgorica"); // Serbia and Montenegro
        CAPITAL_CITY_MAP.put("CX", "Flying Fish Cove"); // Christmas Island
        CAPITAL_CITY_MAP.put("CW", "Willemstad"); // Curaçao
        CAPITAL_CITY_MAP.put("CV", "Praia"); // Cape Verde
        CAPITAL_CITY_MAP.put("ES", "Madrid"); // Spain
        CAPITAL_CITY_MAP.put("EA", "Melilla"); // Ceuta, Melilla
        CAPITAL_CITY_MAP.put("FI", "Helsinki"); // Finland
        CAPITAL_CITY_MAP.put("EH", "Laayoune"); // Western Sahara
        CAPITAL_CITY_MAP.put("FR", "Paris"); // France
        CAPITAL_CITY_MAP.put("XF", "Bordeaux"); // France, Metropolitan
        CAPITAL_CITY_MAP.put("GB", "London"); // United Kingdom
        CAPITAL_CITY_MAP.put("GG", "St Peter Port"); // Guernsey
        CAPITAL_CITY_MAP.put("GN", "Conakry"); // Guinea
        CAPITAL_CITY_MAP.put("GR", "Athens"); // Greece
        CAPITAL_CITY_MAP.put("GS", "Grytviken"); // South Georgia and the South Sandwich Islands
        CAPITAL_CITY_MAP.put("GW", "Bissau"); // Guinea-Bissau
        CAPITAL_CITY_MAP.put("HK", "Hong Kong"); // Hong Kong
        CAPITAL_CITY_MAP.put("IC", "Las Palmas de Gran Canaria"); // Canary Islands
        CAPITAL_CITY_MAP.put("IM", "Douglas"); // Isle of Man
        CAPITAL_CITY_MAP.put("IO", "Diego Garcia"); // British Indian Ocean Territory
        CAPITAL_CITY_MAP.put("JE", "Saint Helier"); // Jersey
        CAPITAL_CITY_MAP.put("KY", "George Town"); // Cayman Islands
        CAPITAL_CITY_MAP.put("LK", "Colombo"); // Sri Lanka
        CAPITAL_CITY_MAP.put("MK", "Skopje"); // North Macedonia, Republic of
        CAPITAL_CITY_MAP.put("MO", "Macau"); // Macao
        CAPITAL_CITY_MAP.put("MS", "Plymouth"); // Montserrat
        CAPITAL_CITY_MAP.put("NC", "Nouméa"); // New Caledonia
        CAPITAL_CITY_MAP.put("NZ", "No claim"); // Neutral Zone
        CAPITAL_CITY_MAP.put("PF", "Papeete"); // French Polynesia
        CAPITAL_CITY_MAP.put("PN", "Adamstown"); // Pitcairn
        CAPITAL_CITY_MAP.put("PS", "Ramallah"); // Palestine, State of
        CAPITAL_CITY_MAP.put("RE", "Saint-Denis"); // Réunion
        CAPITAL_CITY_MAP.put("SD", "Khartoum"); // Sudan
        CAPITAL_CITY_MAP.put("SE", "Stockholm"); // Sweden
        CAPITAL_CITY_MAP.put("FI", "Helsinki"); // Finland
        CAPITAL_CITY_MAP.put("SH", "Jamestown"); // Saint Helena, Ascension and Tristan da Cunha
        CAPITAL_CITY_MAP.put("SJ", "Longyearbyen"); // Svalbard and Jan Mayen
        CAPITAL_CITY_MAP.put("SO", "Mogadishu"); // Somalia
        CAPITAL_CITY_MAP.put("SR", "Paramaribo"); // Suriname
        CAPITAL_CITY_MAP.put("SS", "Juba"); // South Sudan
        CAPITAL_CITY_MAP.put("SU", "Moscow"); // USSR
        CAPITAL_CITY_MAP.put("SX", "Philipsburg"); // Sint Maarten (Dutch part)
        CAPITAL_CITY_MAP.put("SY", "Damascus"); // Syrian Arab Republic
        CAPITAL_CITY_MAP.put("TC", "Cockburn Town"); // Turks and Caicos
        CAPITAL_CITY_MAP.put("TG", "Lomé");
        CAPITAL_CITY_MAP.put("TH", "Bangkok");
        CAPITAL_CITY_MAP.put("TJ", "Dushanbe");
        CAPITAL_CITY_MAP.put("TK", "Atafu");
        CAPITAL_CITY_MAP.put("TL", "Dili");
        CAPITAL_CITY_MAP.put("TM", "Ashgabat");
        CAPITAL_CITY_MAP.put("TN", "Tunis");
        CAPITAL_CITY_MAP.put("TO", "Nukuʻalofa");
        CAPITAL_CITY_MAP.put("TR", "Ankara");
        CAPITAL_CITY_MAP.put("TT", "Port of Spain");
        CAPITAL_CITY_MAP.put("TU", "Funafuti");
        CAPITAL_CITY_MAP.put("TW", "Taipei");
        CAPITAL_CITY_MAP.put("TZ", "Dodoma");
        CAPITAL_CITY_MAP.put("UA", "Kyiv");
        CAPITAL_CITY_MAP.put("UG", "Kampala");
        CAPITAL_CITY_MAP.put("UK", "London");
        CAPITAL_CITY_MAP.put("US", "Washington, D.C.");
        CAPITAL_CITY_MAP.put("UY", "Montevideo");
        CAPITAL_CITY_MAP.put("UZ", "Tashkent");
        CAPITAL_CITY_MAP.put("VA", "Vatican City");
        CAPITAL_CITY_MAP.put("VC", "Kingstown");
        CAPITAL_CITY_MAP.put("VE", "Caracas");
        CAPITAL_CITY_MAP.put("VG", "Road Town");
        CAPITAL_CITY_MAP.put("VI", "Charlotte Amalie");
        CAPITAL_CITY_MAP.put("VN", "Hanoi");
        CAPITAL_CITY_MAP.put("VU", "Port Vila");
        CAPITAL_CITY_MAP.put("WF", "Mata-Utu");
        CAPITAL_CITY_MAP.put("WS", "Apia");
        CAPITAL_CITY_MAP.put("YE", "Sana'a");
        CAPITAL_CITY_MAP.put("ZA", "Pretoria");
        CAPITAL_CITY_MAP.put("ZM", "Lusaka");
        CAPITAL_CITY_MAP.put("ZW", "Harare");
        CAPITAL_CITY_MAP.put("BQ", "Willemstad"); // Bonaire
        CAPITAL_CITY_MAP.put("SX", "Oranjestad"); // Sint Eustatius
        CAPITAL_CITY_MAP.put("AN", "The Bottom"); // Saba
        CAPITAL_CITY_MAP.put("MM", "Naypyidaw"); // Burma (Myanmar)
        CAPITAL_CITY_MAP.put("DE", "Berlin"); // Germany
        CAPITAL_CITY_MAP.put("IO", "Diego Garcia"); // British Indian Ocean Territory
        CAPITAL_CITY_MAP.put("EU", "Brussels"); // European Union (Note: Brussels is often considered the de facto capital)
        CAPITAL_CITY_MAP.put("EZ", ""); // Eurozone (No single capital; Brussels is sometimes used)
        CAPITAL_CITY_MAP.put("FJ", "Suva"); // Fiji
        CAPITAL_CITY_MAP.put("FR", "Paris"); // France
        CAPITAL_CITY_MAP.put("GF", "Cayenne"); // French Guiana
        CAPITAL_CITY_MAP.put("TA", "Edinburgh"); // Tristan da Cunha
        CAPITAL_CITY_MAP.put("TP", "Dili"); // East Timor (Timor-Leste)
        CAPITAL_CITY_MAP.put("TV", "Funafuti"); // Tuvalu
        CAPITAL_CITY_MAP.put("UM", "Washington, D.C."); // United States Minor Outlying Islands (Note: Washington, D.C. is used for representation)
        CAPITAL_CITY_MAP.put("GB-NIR", "Belfast"); // Northern Ireland
        CAPITAL_CITY_MAP.put("XU", "London"); // United Kingdom (excluding Northern Ireland)
        CAPITAL_CITY_MAP.put("YU", "Belgrade"); // Yugoslavia (Historical entity)
    }

    public static String getCapitalCity(String isoAlpha2) {
        return CAPITAL_CITY_MAP.getOrDefault(isoAlpha2.toUpperCase(), "Unknown");
    }
}
