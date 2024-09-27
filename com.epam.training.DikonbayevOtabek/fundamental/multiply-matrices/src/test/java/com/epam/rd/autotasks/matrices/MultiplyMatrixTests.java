package com.epam.rd.autotasks.matrices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplyMatrixTests {
    @Test
    public void test2x2_1() {
        int[][] a = { {1, 2}, {7, -13} };
        int[][] b = { {1, 2}, {7, -13} };
        int[][] expected = {{15, -24}, {-84, 183}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2x2_2() {
        int[][] a = { {0, 0}, {0, 0} };
        int[][] b = { {0, 0}, {0, 0} };
        int[][] expected = {{0, 0}, {0, 0}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3x2_1() {
        int[][] a = { {0, 12345},
                      {4509, 0},
                      {3, 567} };
        int[][] b = { {653, 0, 25353},
                      {0, 61, 6} };
        int[][] expected = {{0, 753045, 74070}, {2944377, 0, 114316677}, {1959, 34587, 79461}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3x2_2() {
        int[][] a = { {0, 12145}, {4509, 0}, {3, 567} };
        int[][] b = { {653, 0, 25353}, {0, 61, 6} };
        int[][] expected = {{0, 740845, 72870}, {2944377, 0, 114316677}, {1959, 34587, 79461}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3x2_3() {
        int[][] a = { {0, 12345}, {4509, 0}, {3, 567} };
        int[][] b = { {653, 0, 25353}, {0, 61, 4} };
        int[][] expected = {{0, 753045, 49380}, {2944377, 0, 114316677}, {1959, 34587, 78327}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_1() {
        int[][] a = {{30677, 22226, 98579, 29722, 99811, 75808, 69830}, {16451, 12335, 15446, 80587, 4606, 1001, 71816}, {13377, 8508, 9017, 14297, 9625, 35281, 84814}, {15583, 55032, 744, 43910, 17507, 11389, 33551}, {20736, 59730, 68865, 64273, 7336, 37991, 49340}};
        int[][] b = {{5713, 1153, 78026, 42712, 874, 40184, 21640}, {11439, 39854, 48725, 29835, 40397, 42793, 96174}, {59566, 50707, 89470, 1940, 62491, 1522, 40563}, {12081, 79616, 6822, 1187, 7102, 97830, 19018}, {65133, 76778, 3676, 99025, 69500, 74207, 75421}, {85454, 28730, 87497, 18289, 10615, 99380, 52115}, {11595, 91888, 30874, 33217, 40897, 47383, 40570}};
        int[][] expected = {{-1025541824, -1225854248, 180164818, -1390177279, 713596099, 2015974611, 202072548}, {-948006113, 1806326925, 1843142776, -238746939, 1023074300, 55486123, -1575357637}, {1213833225, -1388905192, -486432773, 980327299, 1237523992, 1963298921, -839050583}, {-499093873, 1909235207, 2065178401, 1122445713, 1009888056, -1586154770, 1180285600}, {1386672251, 22094325, -1177367019, 1642835016, 1531995488, -740142398, 1858926302}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_2() {
        int[][] a = {{30223, 56835, 19644, 94775, 10242, 50271, 83250}, {50896, 33397, 64875, 86787, 87164, 99285, 9075}, {52743, 5922, 32594, 99492, 92584, 32996, 62654}, {98093, 31617, 44652, 6582, 84614, 40383, 30201}, {14361, 20809, 12289, 38296, 13949, 74108, 36174}};
        int[][] b = {{93529, 66170, 97035}, {58807, 51260, 27732}, {73880, 12492, 43115}, {22497, 74823, 42124}, {78170, 49138, 82901}, {64918, 52863, 12382}, {87883, 78358, 80684}};
        int[][] expected = {{-341992105, 459174972, 356691565}, {1756369461, 1151630698, 30460631}, {-956685341, 1373285986, -1752328557}, {601016811, 640929035, 1074196571}, {531855492, -411509924, 516335491}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_3() {
        int[][] a = {{55159, 60834, 51579, 75438, 8810, 521, 83055}, {50555, 24587, 21820, 40944, 21069, 39277, 97840}, {53030, 99102, 68457, 24949, 91426, 79667, 8686}, {3627, 24437, 47417, 76681, 41420, 21404, 67625}};
        int[][] b = {{56399, 6196, 5574, 76152, 18166, 4849, 7448}, {34958, 94404, 25401, 83070, 71651, 42443, 7564}, {74153, 85622, 39547, 17759, 3033, 71489, 88473}, {78517, 20475, 19352, 83209, 70209, 21096, 25177}, {31495, 39028, 32369, 95145, 64980, 13238, 40108}, {71211, 2926, 34810, 56987, 5299, 6684, 17597}, {93114, 70476, 759, 32687, 72007, 90762, 21085}};
        int[][] expected = {{1558769117, 1064504410, 1423749938, -1445039467, 189607757, -1393307498, 857423601}, {-360457819, 288625754, 390099880, -52167574, 1358338058, 249022922, -1466947715}, {1377039571, -1004947257, -1142771601, -979688787, -168024665, -470176307, 196368731}, {-1753576389, 1519610765, 1842229245, -279942435, 2133798542, 6483861, 1211435223}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_4() {
        int[][] a = {{32143, 67515, 80397, 78660, 79905, 16187}, {10435, 46407, 83515, 3674, 50399, 47124}, {97915, 615, 82597, 99671, 7221, 21972}, {87654, 30247, 70266, 71126, 73357, 17985}, {53749, 79219, 9104, 30890, 21788, 13393}, {95587, 34405, 5118, 47337, 58195, 14853}, {41772, 45045, 93321, 85334, 45625, 35449}};
        int[][] b = {{43177, 79591, 99702}, {60434, 92386, 82938}, {90788, 82316, 35945}, {70205, 15915, 41961}, {72006, 67844, 11995}, {20869, 14082, 91658}};
        int[][] expected = {{-1388909886, 839751329, 257062218}, {-1472202411, -1046017623, 84331234}, {-1735285630, -145269184, 1885228483}, {1167931021, 442115800, 2106651411}, {-933128622, 1619565817, -2138379740}, {1609793277, -1061460768, -566452554}, {1539362043, -1354156494, 1452404606}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_5() {
        int[][] a = {{11979, 37228, 14696, 54079, 805, 16243, 56126, 54100, 2319}, {87991, 33606, 58659, 54969, 93798, 4526, 64912, 91854, 63810}, {20790, 79602, 95998, 64814, 50749, 67633, 98943, 46729, 81549}, {70715, 70802, 20349, 93051, 43249, 38023, 81738, 66959, 74057}};
        int[][] b = {{9686, 63781, 87321, 66169, 58952}, {32208, 13992, 34841, 95375, 67394}, {82820, 25116, 37085, 45163, 64099}, {75855, 7574, 85607, 50267, 68986}, {59197, 12012, 4344, 75363, 46735}, {59292, 89655, 66414, 95204, 13266}, {24132, 10419, 35583, 68931, 14445}, {28725, 88044, 63430, 31665, 36941}, {18043, 56620, 2110, 47159, 19910}};
        int[][] expected = {{2005449081, 418886064, 1148566302, 2138786918, -1888558477}, {664840431, 406061303, -1055624529, -2027932749, -720659905}, {2078065707, 302581874, -703359629, 315763636, -506797995}, {280967522, 110485088, 1617458915, 794868676, -1451448439}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_6() {
        int[][] a = {{3981, 31983, 63168}, {24048, 7732, 61489}, {58162, 76464, 67458}, {62250, 56560, 79404}, {12823, 7256, 29358}, {63633, 55764, 37886}, {22131, 3089, 51186}, {80721, 51590, 79867}, {16428, 15985, 29769}};
        int[][] b = {{63723, 66307, 44826, 79688, 81662, 31436, 27855, 72123, 55748, 86736}, {87953, 3049, 3141, 36030, 54956, 56752, 69334, 64523, 14525, 81090}, {65225, 4474, 88670, 83524, 99249, 27616, 2356, 5638, 46570, 4963}};
        int[][] expected = {{-1403119730, 644097966, 1585050173, -1844305142, -237819590, -610273876, -1817743411, -1588065340, -666747673, -1042667026}, {1928116029, 1893227390, -2035443102, -1259206372, -98485263, -1402107680, 1350815612, -1714986574, 21510638, -1276982181}, {1946541480, 96526266, 238909504, 139271480, -1532949314, -559148904, -1509346058, 918898210, -1095360756, -1304902842}, {1235602442, 360348390, 1418891548, 745672608, -1107330728, -1230329608, 1547613318, -3177210, -600243312, 1789913860}, {-924784749, 1003725897, -1094198542, -559596800, 64697408, 1625646868, 929439617, 1558532521, -2107515232, 1846308522}, {-1454290787, 263872435, 2091951906, 1654419096, -863789844, 1916377996, 1433130511, -188869893, 1826768308, 1639268274}, {725580084, 1705864742, 1245442079, 1855163966, -1532754472, -2010397676, 951225947, 2084052328, -632608563, -1870889752}, {2005702740, 1572022919, -2022651262, 2077192168, 173869041, -918946484, 1718623871, 1010937807, 378850656, -1303672211}, {99485878, 1271216167, -868739653, 76512674, 879591181, -2049255264, 1636041694, -1910892875, -1760614697, -1426101091}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_7() {
        int[][] a = {{88635, 22452, 97472, 87153, 49462, 44228, 59179, 93453, 47613, 82407}, {6751, 14617, 86623, 83300, 27903, 55721, 60758, 81223, 58504, 94607}, {47731, 50647, 19190, 23154, 64464, 70627, 77348, 58052, 46758, 79239}, {21161, 68516, 26524, 19446, 81817, 68735, 75566, 65121, 95860, 90045}, {79423, 95808, 89599, 29432, 88110, 58046, 84486, 37028, 20812, 97584}, {89669, 80030, 60766, 92519, 14055, 56605, 32127, 65405, 54499, 11731}, {63191, 56929, 83696, 52059, 66527, 83094, 7009, 75666, 38233, 21667}, {60983, 13952, 7624, 2341, 18919, 2962, 81379, 20944, 95623, 36964}, {28677, 73982, 54564, 73440, 89566, 27424, 75047, 90360, 6332, 67357}, {78442, 54139, 20623, 35309, 24599, 50357, 99345, 76896, 49828, 53421}, {14355, 23045, 81047, 90322, 50031, 81523, 53914, 68159, 61792, 25607}, {42229, 64227, 35120, 48172, 60692, 53706, 49513, 35687, 17766, 87709}, {93835, 19774, 45548, 7933, 61647, 33090, 62903, 93181, 91127, 51651}, {28038, 9338, 70275, 97877, 85511, 3459, 21319, 32884, 85434, 56446}, {43961, 28090, 7842, 62768, 46302, 94280, 69987, 26555, 90523, 1044}, {73655, 5609, 55547, 26460, 85785, 88451, 31218, 44467, 99512, 73443}, {21705, 76588, 72524, 94433, 30603, 12820, 84189, 81252, 7971, 47873}, {20273, 20947, 87309, 12140, 50827, 13391, 49343, 45999, 85640, 32346}};
        int[][] b = {{62503, 1794, 17557, 47975, 33560, 94208, 35937, 612, 82107, 84875, 85327, 8885, 87452, 55451, 43988, 51033}, {81188, 70022, 82856, 61778, 56832, 64866, 93691, 39127, 18864, 92026, 44941, 34001, 59976, 26460, 98161, 87985}, {2890, 64989, 60528, 56486, 92015, 46962, 44961, 27917, 88892, 58599, 3834, 9895, 39143, 83786, 75817, 93196}, {32053, 45490, 75333, 25470, 88665, 78363, 48753, 49616, 87130, 63366, 83891, 56543, 93801, 29522, 51363, 35734}, {36151, 95160, 37124, 16914, 37587, 15157, 78323, 95441, 23197, 78683, 69217, 80549, 84861, 76296, 83342, 49435}, {48593, 50475, 621, 8895, 48077, 42189, 17708, 44428, 51706, 16749, 28315, 54076, 3630, 76272, 4270, 57476}, {33062, 40709, 39934, 75338, 6462, 10784, 14048, 15603, 32899, 85641, 32270, 15397, 82014, 52423, 89114, 59146}, {71262, 55161, 38779, 2391, 95664, 42753, 20884, 21061, 23721, 35532, 36097, 3017, 69507, 30958, 88473, 2789}, {27707, 44738, 29549, 19305, 1248, 15870, 64395, 49769, 45007, 16012, 15260, 16472, 89124, 37346, 60660, 60328}, {8759, 41322, 11614, 61055, 38688, 40307, 56158, 42321, 10866, 56995, 89786, 93905, 1731, 43204, 8100, 82382}};
        int[][] expected = {{-737296152, 2004195352, 326878380, -542499390, -1152252895, -1819779923, -1010463809, 1937642556, 235776288, 649136813, -18128793, 2060078867, -1768204611, 369997380, 723117170, -1548336088}, {1312068304, -662080371, 847183619, -588480312, 1972508131, -1946768960, -1399681500, 365337493, 1133289717, -245180623, 572198779, 938321740, 1183186560, -1235929393, 1992065871, -1954106730}, {864212493, 1579075773, 839312748, -957155117, 1819907811, 231408724, -1258193568, -379032228, -842754061, 1445861717, 1476463893, 759326273, 479944787, 1835315185, 831703881, 774628672}, {-1303024596, -982896616, 145407499, 958889184, -299788604, 622249906, 532122956, 623950873, 382718883, -430648166, -1500801126, -188352820, 1078142491, 650555403, -1836539793, 1762779903}, {1044392599, 1412940197, 1068471917, 295014837, -1403335563, 688466494, -356426564, 241016967, -507126555, 2074738916, 420011199, 1899246156, -480583889, -1621196331, -1297691741, 1022140589}, {67917294, 185933021, -793876765, -1353651233, 1523422297, 759349409, 282082564, 1237040043, 711734855, -1290283515, 1330711881, -945097140, -1499512884, 783576066, 263143296, 807043543}, {-1971947131, -567828421, 456115663, 56560795, -2021328156, 1190706973, 175397783, 274651947, -2005299764, 502990594, -687356254, 1941659710, -2033571321, -17645656, -1259379904, 611113013}, {140654168, 1026813651, -1999367777, 2023148924, 91033254, -501144894, -1875914826, -2001173457, 1738576504, -1530205003, -1570178629, 680554588, -749420766, -969228894, 69776923, -1549872304}, {-1202918530, -1227708617, 511100509, 1287539840, -1232585568, 50587105, -1436661785, -1684052226, -1645560456, -476664881, 880963699, -1752111423, -1868461377, -973912716, 971422332, -2051845047}, {-1331064244, -1286509311, -1717210208, 453102262, -1559465350, -1332502682, 1093695538, -190621873, 1986636394, -1412098575, 1064592144, -138184502, 162602852, 257733565, -841062169, -506862440}, {-1231179756, -396539989, 1223858487, 363450598, 929067347, 1962272836, -2087258942, 1012305197, -1551586547, -1463057441, 1887190747, -1758104862, -825185830, -816415005, -1373991463, -148620494}, {-1730958058, 166559004, 1829081726, -1252512445, -1187086992, 1156448274, -1092113622, -1266596282, -1063953819, 1007200431, 1649474183, 1347312309, 1290362562, -483911292, -2120380620, 148307951}, {1915227579, 552526370, 1187685444, -1765052912, -1261886070, 1929123520, -1097639298, -1959588887, -868859637, 1396699102, 591189760, -418601646, -1537461318, -1243543588, 644442670, -325539627}, {2135187087, 1102105721, -98617650, -537911105, -199149816, -548701739, 460501735, 1706781105, -414292228, -2140067778, -213794789, -468422604, -400810865, -637487153, 30722146, 2112438569}, {-1433255690, 1507648192, -588368873, 1770369453, 1597808530, 2118764007, -1128886048, 2087819929, 1797461418, -1348171146, -599069404, -632796967, 1585814355, -1438397580, 1087085377, -612680670}, {-406425244, -887929145, -62406143, 1612909226, -623903097, -1975819460, 1375017214, -1040203529, 1548752171, -101367035, -1927706873, -2035282842, -677809086, -1497923605, 170777199, -636344432}, {279373147, -1850690703, 909174025, 1045037159, 2008096928, -508646297, -1244307622, 1478052342, -919344482, 340123678, 275237149, 1000701489, -182361295, -1067851502, -1665501641, -204585080}, {777973735, 1481284120, -333450973, -1237913673, -1862066835, 1932181995, -1063239936, -492394197, -1804529516, 1357541329, -1794408847, -277380658, 1110187177, 1383036516, -1656820575, -161285406}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_8() {
        int[][] a = {{99011, 21072, 62375, 42900, 90421, 89187, 33906, 36964, 3391, 7849, 75577}, {26018, 66634, 98752, 86690, 89826, 40872, 1374, 85342, 17623, 18532, 79908}, {3335, 11213, 87228, 15824, 35299, 20640, 25165, 60087, 47590, 98539, 15771}, {45758, 77036, 4206, 34928, 69640, 15269, 70566, 73298, 4155, 69469, 12288}, {78974, 77716, 57109, 36647, 79618, 34201, 16989, 59364, 37111, 93236, 63075}, {65496, 64737, 32710, 31347, 30386, 90494, 56728, 49849, 80085, 55573, 58026}, {42920, 1571, 92113, 234, 18920, 64003, 57697, 85233, 83969, 75361, 66370}, {70434, 37628, 64379, 54764, 65925, 31434, 26633, 35223, 10840, 40225, 1145}, {74064, 78797, 64050, 40966, 25366, 78950, 19490, 27184, 61534, 44395, 46947}, {59440, 53416, 70153, 50627, 71853, 40367, 58304, 76639, 68456, 4419, 82843}, {12632, 60111, 19493, 84406, 24793, 39065, 92140, 29950, 52329, 7062, 61664}, {21187, 27271, 20747, 87198, 52344, 45420, 77347, 71896, 98257, 69210, 54362}, {5499, 42953, 97728, 18645, 89686, 39695, 59012, 48303, 41654, 18004, 96530}};
        int[][] b = {{85461, 64190, 14692, 93195, 44618, 27771, 1024, 58658}, {79242, 14424, 75491, 9321, 24358, 79434, 50167, 42368}, {24116, 28299, 44834, 14257, 72124, 97547, 40364, 34442}, {24996, 20555, 41169, 8333, 1180, 82692, 16558, 4681}, {64500, 87637, 17304, 32664, 47581, 68953, 71657, 96651}, {62731, 77711, 52673, 15988, 13938, 5212, 54479, 36994}, {77449, 55061, 83355, 43351, 83962, 90207, 65599, 46018}, {39461, 327, 97999, 33917, 4396, 2182, 74485, 24908}, {50132, 41289, 40768, 29998, 99633, 78267, 8857, 24179}, {11963, 81011, 30155, 32602, 23470, 69220, 30756, 60071}, {75581, 37587, 2261, 39435, 55765, 62286, 87644, 70221}};
        int[][] expected = {{-164161142, -407752164, -609877685, -363332543, 1296806855, -654366372, 1827633135, -634840334}, {963886246, 2117163251, 1282227052, -1178077240, 514849145, -1481432033, 1565811107, 1919802373}, {-858946631, -1662115993, -1385789669, -1220108969, 1829965528, 1501479107, 1783602882, 1576606595}, {995093144, 870698359, -288993796, -908335880, -414133741, -2070032893, -1949120998, -2008447254}, {-476630735, 541289882, 206481316, 266804092, -835463824, -1069734075, -1344158323, 2146955719}, {1002487114, -532023192, -1480387912, -948235639, 1333987281, -93744609, 1430117115, 1574235897}, {-850394518, 1522676868, 1825326631, -1518583340, -620390749, -1087081451, 1929346379, 180321876}, {1235552052, -15924724, 1962270308, 2091038656, -358951466, 876690791, 526001669, -879026173}, {1412589606, 117608602, -1335487323, 713858670, -2023964701, -1617056868, 1264778771, -1291451046}, {-1932154588, 809585969, -1078101011, -431568346, -234486588, -316072336, 1229735191, -893887390}, {-1905796551, 2126772774, -1109701002, 510204450, 468689986, -1637441523, 2003185412, 2021487922}, {1502314932, -1825719411, -167906214, 1646426366, 1818437841, 181418876, -1976017197, 191274163}, {982492687, -632164147, -1542626930, -1314515208, -1759245824, -1676658971, 1790186529, -1546585769}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_9() {
        int[][] a = {{51659, 30365, 64841, 96117, 55451, 22591, 40569, 25321, 58339, 26250, 69305, 49084, 12076}, {3439, 45985, 87410, 77067, 5087, 86128, 54127, 64639, 6021, 77016, 41259, 50585, 80707}, {30741, 9775, 24653, 55464, 12311, 267, 32355, 68933, 24090, 14462, 85355, 67548, 9601}, {83319, 89638, 83084, 74671, 27785, 34750, 81789, 96686, 24655, 32011, 40181, 74102, 40736}, {3879, 67733, 71257, 73674, 27556, 78450, 24756, 44488, 21857, 95236, 95465, 35919, 22744}, {9914, 53940, 65985, 29795, 43857, 86151, 37897, 32609, 71606, 1084, 78891, 71658, 48932}, {34700, 18862, 79414, 43394, 8089, 15978, 46819, 21736, 20821, 43601, 99152, 793, 97827}, {49965, 98957, 54165, 40459, 71642, 12228, 80062, 23056, 50800, 42727, 60010, 39243, 53417}, {14870, 50240, 15183, 91924, 79746, 25628, 6311, 6684, 36117, 28431, 90046, 34883, 57688}};
        int[][] b = {{27481, 70252, 54118}, {67541, 2285, 39871}, {99247, 39634, 48735}, {26742, 65506, 21323}, {76321, 54100, 29231}, {42347, 84323, 8636}, {3239, 6524, 6901}, {28650, 54253, 41668}, {73528, 53000, 81480}, {7253, 66776, 23161}, {4087, 3067, 26508}, {84090, 67460, 43128}, {79091, 77908, 23060}};
        int[][] expected = {{-1697258345, -1647419138, 486025499}, {1741271658, 1186114911, 2113129856}, {-49792832, 2060901704, -1589608016}, {-1778664205, 1835348247, 1610598844}, {-2053906550, 699556464, -1422272094}, {445041487, -268783689, 879336060}, {1919437636, -2035165452, -526416915}, {-1124713699, 1982185751, 2033893300}, {106450553, -171488688, 25425553}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHighRank_10() {
        int[][] a = {{13866, 64074, 82889, 7951, 27643, 77679, 66496, 49160, 52394, 41907, 12745}, {66706, 3193, 96581, 79260, 92292, 26556, 99244, 58061, 79043, 98899, 64571}};
        int[][] b = {{65793, 40255, 94235, 59822, 46273, 73614, 70027, 65787, 86103}, {71005, 56540, 76826, 54493, 29021, 63169, 4939, 26780, 43289}, {92390, 95185, 74651, 53731, 96964, 13611, 55434, 47160, 63416}, {89290, 68208, 73739, 47008, 75795, 11966, 84496, 87403, 90245}, {86575, 85297, 70505, 34874, 2871, 40894, 48082, 20422, 86902}, {61726, 73889, 50350, 11429, 97490, 66490, 24670, 86433, 17153}, {67858, 69212, 37389, 95185, 54428, 78119, 26275, 74233, 45376}, {23682, 89733, 81585, 31494, 9380, 76078, 21018, 73071, 57272}, {30702, 18467, 76875, 57841, 40177, 10765, 99793, 62744, 90865}, {1462, 81971, 35911, 72835, 65743, 51870, 76229, 18412, 73022}, {44484, 2066, 79606, 63210, 59671, 11011, 25902, 11818, 37729}};
        int[][] expected = {{-1133534895, -206573406, 1842820496, -3346753, -1570476674, -1370259950, -141581019, 1478830490, 2041070385}, {848698251, 1833601704, -893926552, 784038056, -2067107292, 1712096768, -191546883, 634871851, 764484359}};
        int[][] actual = MultiplyMatrix.multiply(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }
}
