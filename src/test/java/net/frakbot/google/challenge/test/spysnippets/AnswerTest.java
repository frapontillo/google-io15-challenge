package net.frakbot.google.challenge.test.spysnippets;

import net.frakbot.google.challenge.spysnippets.Answer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Francesco Pontillo
 */
public class AnswerTest {

    @Rule
    public Timeout globalTimeout= new Timeout(1000);

    @Test
    public void testCase1() {
        Assert.assertEquals("google employees can program",
                            Answer.answer("many google employees can program", new String[]{"google", "program"}));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals("c d a",
                            Answer.answer("a b c d a", new String[]{"a", "c", "d"}));
    }

    @Test
    public void testInverseOrder() {
        Assert.assertEquals("c d e",
                            Answer.answer("a b c d e f g", new String[]{"e", "d", "c"}));
    }

    @Test
    public void testMixedOrder() {
        Assert.assertEquals("a b c d e f",
                            Answer.answer("a b c d e f g", new String[]{"c", "f", "a"}));
    }

    @Test
    public void testSingle1() {
        Assert.assertEquals("a",
                            Answer.answer("a", new String[]{"a"}));
    }

    @Test
    public void testSingleInLots() {
        Assert.assertEquals("a",
                            Answer.answer("there is a lot of text in this sentence", new String[]{"a"}));
    }

    @Test
    public void testMultiple1() {
        Assert.assertEquals("lot of",
                            Answer.answer("there is of a lot of text in this sentence", new String[]{"of", "lot"}));
    }

    @Test
    public void testMultiple2() {
        Assert.assertEquals("program by google",
                            Answer.answer(
                                    "many google employees can program in a program by google in such an amazing awesome program",
                                    new String[]{"google", "program"}
                            ));
    }

    @Test
    public void testShitload() {
        Assert.assertEquals("purus facilisis id quam vitae eleifend tristique ligula curabitur luctus sodales commodo vivamus tempus a lorem a viverra donec id dolor in sapien ornare blandit aenean porta lorem ut erat auctor sit amet",
                            Answer.answer(
                                    "Lorem ipsum dolor sit amet consectetur adipiscing elit Donec facilisis nibh id nisi sodales dictum Aliquam tincidunt a magna sed pulvinar Donec non ante at dolor maximus fringilla hendrerit vitae dolor Curabitur in ullamcorper nunc eget fringilla lacus Nunc efficitur eros sapien vel vestibulum metus congue eu Morbi faucibus purus nec augue facilisis id scelerisque ante eleifend Curabitur vel malesuada eros " +
                                            "Maecenas vitae pulvinar nunc Aenean id convallis enim Cras malesuada lobortis neque at mattis ipsum ornare et Proin luctus porta quam Pellentesque volutpat pretium lectus at sagittis Donec a nisl justo Cras blandit molestie ante quis congue Aliquam non lorem lacinia feugiat velit quis sodales dolor Suspendisse potenti Quisque porta sem sed iaculis rutrum lorem enim aliquet est non pharetra purus nisl id ex Nunc enim magna tempor eget luctus at feugiat ut sapien Aliquam ut tristique eros Nam faucibus tortor non vestibulum tincidunt dui dolor fringilla magna et porttitor ligula ipsum nec enim Integer semper orci at enim semper iaculis " +
                                            "Vivamus placerat aliquam nisi id eleifend Nulla facilisi Praesent tempus tincidunt est quis viverra Nulla at malesuada massa Fusce ut mauris consequat venenatis diam non egestas dui In fringilla euismod ligula eget varius nisi Integer congue efficitur augue at euismod eros placerat ultricies Aenean pretium at ex efficitur egestas Duis velit leo viverra sed vulputate a faucibus ac tortor Curabitur tristique dolor nec lectus fermentum ac tincidunt lectus sollicitudin Proin ut sodales risus Curabitur auctor orci ut sapien molestie ultricies Donec nec massa libero Nam metus enim sagittis et mauris at faucibus vehicula felis " +
                                            "Donec vulputate elit at mollis vulputate nunc tellus varius urna ut molestie arcu magna nec odio Proin efficitur lacus vitae odio tempor vestibulum Aliquam diam neque posuere ut rutrum sit amet efficitur ac quam Fusce et erat id leo scelerisque consectetur Cras vestibulum hendrerit dignissim Cras et ipsum nec erat faucibus rutrum Aliquam erat volutpat Duis velit dolor feugiat at leo a rhoncus dapibus metus Integer quis augue eget nulla volutpat blandit Duis justo odio euismod et mollis quis facilisis eu quam In nec dolor facilisis nisi feugiat egestas " +
                                            "Aenean placerat augue cursus luctus dapibus metus libero aliquam odio vel suscipit leo mauris nec tellus Nulla facilisi Praesent accumsan vulputate mauris et volutpat dolor luctus sed Phasellus vitae neque elit Interdum et malesuada fames ac ante ipsum primis in faucibus Integer eu semper quam Donec lobortis felis nec fermentum tincidunt est nulla consequat augue vel cursus nisi eros quis velit " +
                                            "Maecenas elementum pellentesque neque eget posuere tortor Pellentesque nec nunc mi Donec faucibus commodo mi at dignissim nibh sagittis ut Aenean dapibus augue nec imperdiet aliquet Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Etiam elit felis vulputate vitae ligula in feugiat tempus felis Sed eget mi eu arcu molestie egestas ac nec metus Nunc blandit in erat eget volutpat Etiam mollis vulputate lorem vitae pellentesque ante vestibulum sit amet Pellentesque sed lectus vestibulum ultricies tellus id varius eros Maecenas pulvinar aliquam varius Sed molestie at neque non rutrum Maecenas luctus ut ante vel dignissim Donec ut varius diam Suspendisse rhoncus erat id est luctus eget eleifend erat molestie Mauris tincidunt ac augue sed auctor " +
                                            "Praesent facilisis velit ut elit maximus rhoncus Duis placerat nisi a ultrices molestie Nulla ac tristique neque Aliquam erat volutpat In metus velit cursus vel quam nec dignissim ornare nibh Sed orci purus facilisis id quam vitae eleifend tristique ligula curabitur luctus sodales commodo vivamus tempus a lorem a viverra donec id dolor in sapien ornare blandit aenean porta lorem ut erat auctor sit amet ornare nulla pellentesque Phasellus elementum ligula vitae ornare pulvinar Nam scelerisque finibus tortor nec fringilla Curabitur vitae feugiat mi nec porta metus " +
                                            "Pellentesque auctor molestie quam a gravida Vestibulum nec odio enim Curabitur leo sem dignissim non dui quis consequat vestibulum nisi Pellentesque varius ante nec scelerisque scelerisque ante nisi dignissim mauris ut pellentesque nisl dui ac libero Vivamus vitae nisi dui Suspendisse tellus orci malesuada in fringilla eu tincidunt et dui Duis blandit nulla at dignissim egestas tellus turpis finibus est eget mattis ante ex vitae dolor Phasellus nec convallis lacus nec sollicitudin enim Donec id quam efficitur volutpat elit nec vehicula quam Vestibulum arcu tortor convallis eu dignissim ac egestas ultrices velit Cras iaculis at libero vitae condimentum " +
                                            "Ut ac turpis dui Fusce purus felis molestie eget varius a egestas vel nunc Quisque euismod tempus leo in mattis eros bibendum vitae Donec eu ligula congue vulputate augue vitae tempus tellus Proin bibendum velit eros sed dapibus quam convallis hendrerit Integer placerat scelerisque lectus sit amet tempor lectus condimentum eu Aenean nec tellus nisl Cras hendrerit orci lobortis tempus justo vel tempus erat Pellentesque vel pretium erat Phasellus vitae odio quis ipsum viverra vestibulum quis vel nunc Donec vel mollis enim Nulla rhoncus dolor sit amet lectus ultrices",
                                    new String[]{"amet", "purus"}
                            ));
    }

    @Test
    public void testMultipleSame1() {
        Assert.assertEquals("program by the google",
                            Answer.answer(
                                    "many google employees cant program by in a program by the google in such a amazing awesome program",
                                    new String[]{"google", "program", "by"}
                            ));
    }

    @Test
    public void testMultipleSame2() {
        Assert.assertEquals("b | a x c d",
                            Answer.answer(
                                    "d c b x b | a x c d | | a b lol a b ahahah x c d",
                                    new String[]{"a", "b", "d", "c"}
                            ));
    }

    @Test
    public void testMultipleSame3() {
        Assert.assertEquals("world there hello",
                            Answer.answer(
                                    "world there hello hello where world",
                                    new String[]{"hello", "world"}
                            ));
    }

    @Test
    public void testMultipleSame4() {
        Assert.assertEquals("world hello",
                            Answer.answer(
                                    "world hello world",
                                    new String[]{"hello", "world"}
                            ));
    }

    @Test
    public void testMultipleSame5() {
        Assert.assertEquals("world hello",
                            Answer.answer(
                                    "world there hello there world hello",
                                    new String[]{"hello", "world"}
                            ));
    }

    @Test
    public void testLimitsNumbers() {
        StringBuilder sb = new StringBuilder();
        String[] all = new String[500];
        for (int i = 1; i <= 500; i++) {
            sb.append(i);
            if (i != 500) {
                sb.append(" ");
            }
            all[i - 1] = String.format("%d", i);
        }
        String str = sb.toString();
        Assert.assertEquals(str, Answer.answer(str, all));
    }

    private final String[] randomUnique = new String[]{
            "anoeoajytn", "leihynoymb", "rojqkeetgi", "ziclqtuokn", "oqugkqrsvp", "mjmsfdhmmk", "ydbnadjrwj",
            "vkutwsrbvj", "xrsjybeyva", "wyzzybnyht", "atgncfawxq", "nxxtjablkc", "kofitethdv", "aiimouwrna",
            "skhekqujjh", "yzsqkexdgx", "pxthzmgvll", "pjqjeoxwun", "koasfstsei", "nafeuscyau", "ylksgewpjm",
            "lywvtsovxy", "kfeguwmxhc", "oucblvilym", "pwclsrobbi", "cprrdhrbtj", "jfstrrofvz", "tnkilklrfg",
            "tvpdjvmqvp", "sylxytnzqx", "uudolwvfmb", "izmiqhftev", "jgkeqdpeah", "gkiktaewsz", "aqwfytddhv",
            "bonkxlfnhm", "bjlydvolrs", "pblekxvohg", "hmzhacpzsq", "htxzaurvfv", "idbhwszyic", "gqqxcozfst",
            "rdlgdpcazk", "wlkdhnjprh", "ukurnimnrz", "ewrbpwecqx", "gdwhiizttv", "nbosebflgk", "yywcgwiadc",
            "lqkkuptraz", "mswxdraqyb", "jhcnrhhbkj", "lsqcukljhu", "kqwnwuaafm", "zgwwexcffp", "pybjjzqndc",
            "tgdscvnzeh", "bjztecnpbl", "xbyqnjfjbw", "ffdecqpoma", "rjunvgydks", "lvbzmssham", "ptmxpiwhfe",
            "gcjokbldlc", "lwtjfcahkj", "nughcwaubh", "gxpbdxkydt", "vbzuyhlqpf", "fhzgyddcsf", "wwfmtpuwkg",
            "rhjjjtrubx", "bxxtkforyg", "dpaowtfkir", "iecwnhivrh", "hrttsedpnt", "kqfocsmbmu", "ptlkbbbvge",
            "lrrnzuqmgg", "avvwvjuhzu", "brkbdkynwf", "wiecbyteqi", "jokdmloixy", "itxncuzgbs", "tuijssyssp",
            "mimspazhan", "auxafgdqde", "ghngrzmuxz", "ourfbltzaa", "ptniybffli", "omlhheuzsi", "ghdagnrpex",
            "vrkhasifhc", "czywnbkkgm", "tcnqstrpae", "fgxfnpriyh", "ctkqgnockp", "yzcxuiwqio", "yciphschah",
            "ytlpvjaqda", "xnzntshcyp", "jcjuzfxesz", "jaenbigwid", "dmaxkwpipm", "hodonilgiy", "nemzuupcli",
            "gwifbhafhm", "ikfymuzmyq", "tqdmpxyodr", "dohnjujqig", "dkpmgwwugq", "aicbxeweib", "mteizvorqp",
            "vfnzkeomej", "hqxkkmntih", "guhuzrnxpu", "oxjuyuslfv", "lyqqakvsdm", "drksctnazd", "bzyoqebrfe",
            "atmipgkzwq", "aahtgopxtc", "vwjjnlxobd", "auychjbpva", "swwytijfwu", "cgudjpqxwp", "kwzranbiuy",
            "czrppepnoc", "hafyukbths", "sxdttbcosb", "ijbavvqhlb", "ksibnpysin", "mgxmreagli", "lxiqfbqvsp",
            "hxkaazewsq", "chajmakmbk", "ldomjnwqba", "atsibsnfyh", "qguqbidaxm", "izgbisbxfa", "nbynwjqhea",
            "qqcjiofbqq", "lqbfkjaiwi", "fzcwxetldy", "epjeksswkv", "clcptebguz", "wpijezsgpv", "vxlcuyiejj",
            "ielsnsibex", "lwecssfgzb", "txmuidbvon", "prbtkhuyss", "fzdkdkmker", "gjtlbscjpk", "uxhcypztkh",
            "ugpkwqdcpg", "rqpootnptt", "ohdkuwlvjw", "vxoepyzyjm", "gtdefckdjm", "dhvihhtpyp", "zwbujznavu",
            "vnqutvfzza", "aincznextf", "uabogawjxz", "bjqgkjwwie", "sixoofpqfy", "vmcashikig", "spapvfvahr",
            "dirkzctrph", "omuxflyifu", "svyfzllhdv", "syivcvrtog", "icmqfjethy", "rskotvmguu", "boqnoyllor",
            "uwovhioxpi", "tdxgowxsle", "nqmsavunag", "xgjyfmvnte", "gxmcgrjeys", "cgckupwvsr", "bylkbxcgdq",
            "pbmgwizzxr", "ukacsgfrtw", "ghzinvjuob", "srbmmqywzh", "cdgvuhchui", "tshjsarlgv", "ajejqeeoir",
            "abfvmonhom", "sylrkdolqm", "gulugegzlb", "hoppbtwwdn", "cwomdykkoz", "sezbuwbqwi", "vselwssuxy",
            "axlfbuuwmy", "ynhmgldwxk", "wrdnvxvfjb", "herbnhijzc", "gewmluorlo", "mhviteyvlr", "ucmotguhqy",
            "dniwigqlgn", "qcdylgunfx", "zdfwknkhju", "cxfhzlscgq", "utrsndlayq", "dmfoldtthp", "ozynqxtkjr",
            "yvyxqbzegg", "ddonzkpawb", "gjxmgtfsxo", "ypmnryxslt", "eywvlipmuw", "aqivdrtxlm", "vmjoqwjejq",
            "qwaphnjskx", "sfhcmjnyro", "bbtrmnibmq", "ekzujwldsa", "zjddsucvio", "mmyyjuwnmj", "tcimdarswg",
            "cangscddwx", "qxukzdmlvq", "mmiwjtwwac", "qrzqggwxni", "mrmxrtjubc", "rxcgtzeqdc", "nxwbqwinnd",
            "nnpgreeciy", "jufsnacwse", "nkvpywwfjs", "tsclcodmrl", "rirywavfrh", "uffjmicpwq", "viyunlqsbc",
            "bmdgpgvbeh", "jrsjwzywxw", "voyegxaemt", "pvptpqwptw", "ckhvvlhvai", "prdlgqzekr", "xpvcyarrzz",
            "blwcnujyrr", "uyqlcgcbwx", "qlyxqeawqx", "tstzlzlnrz", "pznspkotta", "dafsglvzyf", "eejyfzgews",
            "nmvlrtryyr", "qqhiomgfbl", "ztzlwrefdr", "fliyjjndvt", "vjeddgqjiy", "nysqupqcwd", "icwkztlkln",
            "rlgukzzgei", "mydtsuplyw", "hdvboiswuj", "mtvqbcnlei", "cptntdhnwn", "jnlayulwbj", "guahaebhjy",
            "jwkrrurosw", "nkhwyecbur", "sunzfykjfv", "qwnwexwcbg", "ajbxmfhvox", "bqikzonchh", "wwwcriyesf",
            "atirpbnnzh", "eewvrbqwqa", "gwefeznfqh", "nbljfwjaui", "bzdhrhdcdj", "heupgfldff", "wwprlinvny",
            "rqrcnwwiyi", "hxperbfneg", "dfumcbpruu", "vubfzcnxzl", "brehaeedbn", "rejnjnfyfi", "vnorjhpqvm",
            "zjswiajegc", "yoyocnhsii", "bstmqxwevn", "hhvsweyuat", "iumrglgula", "rahqxtyaxl", "uitfnaokmc",
            "undbpqbscb", "hskrkupmoc", "dvgvjokjjz", "pmmjuwqfbe", "tnfgarxwxa", "mdxflnpbfz", "tdwizwapwf",
            "pwhnqgdkfh", "lydunrzklz", "dzlkujnvrp", "vncygrsgqj", "jqsochxbuy", "uijogytyvx", "jhbnwtrwzq",
            "zobhhzupjk", "pevdzconrb", "jrsmdluovu", "chujozayjb", "tdvrngqjam", "qcegcuanzr", "wrhqsuvdhq",
            "abixgrmviy", "xehvgvkjcu", "ulaiznzbpr", "ddvseqqfca", "dphwcdrgip", "agvpxzeziv", "ddmoxjieny",
            "wpwppgfqlo", "koskdnaell", "spicgnmekp", "dtcyhuzvng", "wvqfkxhurb", "mbdsvnzzgh", "oyemobexum",
            "atsiempwhk", "nzmpmnkcfz", "crummjwxnn", "jrpgceapgt", "icgzyfnujp", "qwbgbyyvxq", "jclojravjo",
            "ziivadgbxq", "cxreoxaytz", "coahrixxrc", "ckqzvxvdox", "zowdnuwkbt", "hshfduwgtx", "keuhsqrkdo",
            "ogrykzbaxp", "jrdsjmgdxz", "oeohzkvypr", "kdqlgcyvvl", "wytufqezhn", "vnnkdxockw", "olxnaumwph",
            "kywpyczdka", "yrdhwebvgu", "sugkxoszsy", "pnbzszaqao", "oggzjugdav", "cncnxwybwr", "damenrzhue",
            "wmgbjrjioz", "nezrekettw", "egwurbmnyf", "gkzwvvphlx", "okjqoreldp", "dxseobqqiw", "ojchxyndkl",
            "zvruyyvugl", "ikjzvnfkpb", "gowwivqhmk", "mjtstewcsz", "msvmxnfwbl", "rhjdfitfzz", "sdvcwlvhfp",
            "wzdqqtnxnn", "yhxgsiideg", "fahqqsfdvd", "ggufogovgj", "yrraqbpcfo", "eoxyzwrnzc", "nyufehodwo",
            "jvwsndewzp", "vvxyiegzez", "ixifpvahen", "ktesnxpdnc", "whypynzncu", "mdldxknwkp", "urkjoyqakm",
            "ozwttlierh", "znspvzulol", "pahzfylpsu", "bipxfmobwp", "lsrgxvneww", "vaesbbbjmp", "gkrselqhkv",
            "vyqruhgyeo", "ueqalmidbg", "fgcznmezgn", "kzrmfyedfw", "wcbufusyof", "ppsudqynsr", "xcxsjfqntq",
            "zomqhpdnpc", "acbhwfmmwv", "vhexnwxpmt", "nzpauywrco", "fwzdteujpn", "gorpcwtjqa", "pxzxwltnuf",
            "fisavbxsdj", "rlqltqzqpv", "icweosdpps", "iexjpryoiw", "kauqaohvpf", "didvcjmknp", "spceingvfx",
            "wgtrwkingw", "tgxswcsecn", "hdwsvzczxw", "jjtsofpgtp", "ejztnwmluc", "eedvidwvbq", "bzlhphqito",
            "korxcqqglj", "vfngmqtlbf", "tfdsnrxxyd", "jxvcljrrba", "zzbocahmes", "oqwjscjovy", "fzimyvpxxx",
            "kwyvypfpiq", "qslvkemihi", "fdkqroibka", "muszvuuadu", "ksrgnynkwp", "trjrqisksi", "yucutgtgmj",
            "auuqzzliar", "tuykwaadet", "kvwdhbumzq", "mkfypwgwau", "tthtuppfal", "scyveepqph", "shihocpisv",
            "bruujwepow", "gyvcepbnxy", "encogrurpl", "makhjwoclc", "mwouxrnjpc", "klejcbmteo", "yrlddorbae",
            "cjwduvqtmu", "fkkxyytzqj", "hpbjsjubbh", "wgydihhkrk", "ukgflrxhvn", "gmgyrflgzf", "dstyomlvvr",
            "rjtfiuqxrc", "uydnzziwyo", "bmomnpijki", "wgvzcqabst", "ymzuhjowkt", "lbiswsamul", "iunegfbzwd",
            "jdmozxndkf", "zdfjorqujw", "zpedqdwhjt", "ennrjyaija", "ojetyxvqkn", "uaypedhkpp", "sxbdthmlbg",
            "gitwjaewmg", "zlywynjapx", "tgawsczlyy", "vgttteiqgx", "jpqxplvruy", "iltzkkqhbj", "twgrspvcna",
            "dbobfimyrw", "iecxengzjm", "vprxlrctlc", "vongzjaxwb", "kyoutejxch", "gudutpcxyv", "tgonfwesbi",
            "loyblptztq", "qjjjyieggj", "vfzioiexny", "cgjbbnoliw", "xpuejztohx", "zwwgxlbpuz", "aktvyjaaus",
            "fxpgpnweti", "pqphqvgiqt", "impcgoakuz", "zfnaxmfphg", "myeriklsje", "lzijzthrvd", "srhetspbph",
            "vwnqywupum", "iuifeolbhq", "ypnpqqyzxa"
    };

    @Test
    public void testLimitsRandom() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randomUnique.length; i++) {
            sb.append(randomUnique[i]);
            if (i < randomUnique.length - 1) {
                sb.append(" ");
            }
        }
        String test = sb.toString();
        Assert.assertEquals(test, Answer.answer(test, randomUnique));
    }

    @Test
    public void testLimitsRandomInverted() {
        String[] inverted = new String[randomUnique.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randomUnique.length; i++) {
            inverted[i] = randomUnique[randomUnique.length - i - 1];
            sb.append(randomUnique[i]);
            if (i < randomUnique.length - 1) {
                sb.append(" ");
            }
        }
        String test = sb.toString();
        Assert.assertEquals(test, Answer.answer(test, inverted));
    }

    @Test
    public void testLimitsRandomRandomized() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < randomUnique.length; i++) {
            sb.append(randomUnique[i]);
            if (i < randomUnique.length - 1) {
                sb.append(" ");
            }
        }
        List<String> shuffled = Arrays.asList(randomUnique);
        Collections.shuffle(shuffled);
        String test = sb.toString();
        Assert.assertEquals(test, Answer.answer(test, shuffled.toArray(new String[]{})));
    }
}
