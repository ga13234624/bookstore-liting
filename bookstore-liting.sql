-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

use heroku_596fd9c4945818e;

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` bigint DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `discount` double NOT NULL,
  `introduction` longtext,
  `language` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `publishdate` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `sales` bigint DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `simpleintro` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8  COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,11,'小車',0.79,'文科生、平凡30歲世代小資上班族，\n用獨創的「金融股543規律」及持股配置，\n買在低點、迅速累積股票張數，4年內讓資產成長近40%！\n目標是靠存股滾出「有選擇」的人生！\n★每省下1萬元，未來都能翻漲5倍！\n★堅持「只領股利」，上班族也能靠月薪創造買房現金流！\n★最務實的「選股+持股比例」策略，享受生活無後顧之憂。\n\n價差族常質疑存股族是不是因為不會操作價差，才來存款？小車很誠實地告訴你：「是的，我不會，而且也不想。」穩健投資、專注本業，才是小資族的致富王道！\n\n▎為什麼「金融股」是小資族的最佳選擇？\n殖利率高、波動極小，最重要的──價格起伏有慣性、不受炒作影響！\n只要掌握除息日，搭配小車獨創的「543規律」，就能買在低點，輕鬆累積張數，降低持有成本、加快資產累積速度。',0,'給存股新手的財富翻滾筆記',380,'2022-03-16','幸福文化',10,'商業理財','給存股新手的財富翻滾筆記.jpg','文科生、平凡30歲世代小資上班族， 用獨創的「金融股543規律」及持股配置， 買在低點、迅速累積股票張數，4年內讓資產成長近40%！ 目標是靠存股滾出「有選擇」的人生！'),(2,3,'陳逸朴',0.79,'巴菲特曾說：「如果你沒辦法找到在睡覺時也能賺錢的方法，你將工作到死。」\n \n　　面對人生珍貴的每分每秒，你不需要深奧的投資技巧、不需要每天盯著股市的數字，一年只需要花費5分鐘時間，用指數化投資就能實現小資族千萬美夢。\n「指數化投資」是一種無關你的背景、資金大小，任何人都可以採取的投資方法，你只需要理解指數化投資的理念，就能始終如一地投資。★選對方式，讓你投資賺錢就像呼吸一樣自然★365天錢滾錢全攻略，睡覺時也能自動進帳★超越通膨，讓你不用擔心資產貶值★擁有更多時間享受生活，追求夢想',0,'一年投資5分鐘：打造每月3萬被動收入，免看盤、不選股的最強小資理財法',360,'2021-12-29','遠流',5,'商業理財','一年投資5分鐘：打造每月3萬被動收入，免看盤、不選股的最強小資理財法.jpg','巴菲特曾說：「如果你沒辦法找到在睡覺時也能賺錢的方法，你將工作到死。」面對人生珍貴的每分每秒，你不需要深奧的投資技巧、不需要每天盯著股市的數字，一年只需要花費5分鐘時間，用指數化投資就能實現小資族千萬美夢。'),(3,3,'鄭安民',0.9,'雖然時代在變化，可抱有以上種種想法的人，還真不少。大概是被「投資理財」這個專業名詞給嚇唬住了！很多人寧願選擇坐在電視機前喋喋不休地抱怨著「物價飛漲，錢不夠用」，也不願意挪出一點兒時間，去研究一下「讓錢生錢」的好方法。',0,'第一本投資理財入門書',350,'2022-04-06','布拉格文創社',0,'商業理財','第一本投資理財入門書.jpg','雖然時代在變化，可抱有以上種種想法的人，還真不少。大概是被「投資理財」這個專業名詞給嚇唬住了！很多人寧願選擇坐在電視機前喋喋不休地抱怨著「物價飛漲，錢不夠用」，也不願意挪出一點兒時間，去研究一下「讓錢生錢」的好方法。'),(4,0,'陳真',0.85,'多年來廣受讀者愛戴與市場檢驗，自民國95年至今已發行至第16版，且年年榮膺國考題庫書暢銷排行榜第一名，指名度最高。首創一百大焦點主題式筆記整理與考古題收錄，且為國考其他科目（如行政法、法緒......等）所仿效，形成百分百系列題庫。',0,'行政學百分百',750,'2022-01-19','志光教育科技',8,'考試用書','行政學百分百.jpg','多年來廣受讀者愛戴與市場檢驗，自民國95年至今已發行至第16版，且年年榮膺國考題庫書暢銷排行榜第一名，指名度最高。首創一百大焦點主題式筆記整理與考古題收錄'),(5,15,'劉子超',0.79,'蘇聯解體20周年的2011年，劉子超第一次去到烏茲別克斯坦，有一晚他從酒店出來，看著天下起鵝毛大雪，雪花在昏黃的路燈下飛舞。酒店門口停著黑車，司機留著小鬍子，戴著鴨舌帽，守著破舊的拉達。那一幕帶他穿越回到1990年代——當時他所在的北京，就是那樣呈現著後蘇聯、幾乎被世界遺忘的所在。9年後，他交出一本記錄中亞大陸旅程之作《失落的衛星》。',0,'失落的衛星：深入中亞大陸的旅程',420,'2022-03-30','新經典文化',5,'文學小說','失落的衛星：深入中亞大陸的旅程.jpg','蘇聯解體20周年的2011年，劉子超第一次去到烏茲別克斯坦，有一晚他從酒店出來，看著天下起鵝毛大雪，雪花在昏黃的路燈下飛舞。酒店門口停著黑車，司機留著小鬍子，戴著鴨舌帽，守著破舊的拉達。那一幕'),(6,18,'Sophie Kinsella',0.79,'《我的A級秘密》作者蘇菲‧金索拉再次推出關於家庭的暖心之作',1,'The Party Crasher',665,'2021-10-12','新經典文化',2,'文學小說','The Party Crasher.jpg','《我的A級秘密》作者蘇菲‧金索拉再次推出關於家庭的暖心之作'),(7,24,'雪倫',0.79,'人生跌跌撞撞，談幾場少年不識愁滋味的愛情，狠狠愛過狠狠痛過，然後，掙扎起身，拍拍塵土，幸運的，拿得起放得下，瞬間重生，又是一個全新的人，馬上可以再愛下一場；傷得重的，誰說非得馬上剝開血淋淋的傷口，處理裡頭的惡膿，傷痛才真正會好？反正時間到了，事情就會解決。這年頭，誰不是在心底扛著幾道傷疤過日子？',NULL,'慢慢 慢慢愛',280,'2022-04-02','商周出版',8,'文學小說','慢慢 慢慢愛.jpg','人生跌跌撞撞，談幾場少年不識愁滋味的愛情，狠狠愛過狠狠痛過，然後，掙扎起身，拍拍塵土，幸運的，拿得起放得下，瞬間重生，又是一個全新的人，馬上可以再愛下一場；傷得重的，誰說'),(8,20,'股市隱者',0.79,'股市隱者，「股市隱者」臉書粉專版主，曾任職國內前三大法人機構的海外基金部門，是部門中最年輕的基金經理人，管理高達2億美元部位，操盤期間績效為部門第一，年化報酬率超過30％！離職後成為全職投資人，目前個人年化報酬率30％以上。粉絲總是好奇的問：「為什麼要自稱股市隱者？」我的答案很簡單：讓我虧最多的，往往是覺得最好賺的錢，賺最多的，偏偏是覺得最無聊的股票。所以我學會了隱於市，讓等待變成習慣，因為該來的終究會來。就像價值投資，看似孤獨，我卻享受寂寞，時間成了我最好的朋友。\n ◎投資是找金礦，有地圖也需要羅盤\n．基本面分析，就像看面相或八字：看得再準也看不出哪一天或哪個月發生。用公司所在產業的成長性、營收比或是領導者特質，可以相當程度的準確預言它的未來，至於這個未來何時會發生，需要時間證明。\n．技術面分析：像間諜用手語打暗號，訊息不能言傳，只能意會。股市裡人為操作的可能性很高，以致這暗號的動作總是打不那麼標準、也可能我們看錯，不能只看一個指標，成交量、K線型態與均線最好一起參考。\n．籌碼面分析：老鼠雖然小，但只要騎在牛上，也能成為生肖老大。跟法人相比，散戶處於資訊不對稱（像老鼠），\n如果能觀察買賣超（籌碼）背後是誰，就能多個參考資訊。最重要的三個籌碼分析：內部人持股異動、實施庫藏股、券商分行買賣超。',0,'隱市致富地圖',420,'2022-03-29','大是文化',0,'商業理財','隱市致富地圖.jpg','股市隱者，「股市隱者」臉書粉專版主，曾任職國內前三大法人機構的海外基金部門，是部門中最年輕的基金經理人，管理高達2億美元部位，操盤期間績效為部門第一'),(9,5,' 賴憲政',0.9,'對抗M型化社會趨勢，理出親子富未來\n趁早金錢教育Ｘ釐清理財迷思Ｘ小資家庭投資法\n（股市憲哥的親子理財學修訂版）\n \n\n廣義來說，財商（FQ）就是指理財能力，\n一個人提升財商，通常就能翻轉財務狀況。\n\n像很多知識一樣，財商可以透過後天的學習來改變，\n不只要學如何賺錢存錢，更要學管理金錢與分配資源。\n從給零用錢開始教，循序漸進讓孩子練習支配個人財務，\n隔絕負債體質與掌握富人公式，親子都能提升理財力！\n\n\n【各領域強力推薦】\n朱紀中 《Smart》雜誌社長兼總編輯\n盧燕俐 資深財經媒體人\n鄭凱云 TVBS主播\n李佩甄 理財書作家\n季　芹 理財書作家\n \n\n股市憲哥首度分享：\n讓爸媽這代＋孩子那代一直有錢的關鍵14堂課\n \n親子金錢教育篇_終結「惡性循環」，錯誤觀念要RESET！\n‧談錢太俗氣？順其自然，長大就會懂？!\n　孩性本惡。世界首富猶太族3歲起和孩子談錢',0,'股市憲哥的14堂財商課',360,'2019-04-20','新手父母',250,'商業理財','股市憲哥的14堂財商課.jpg','對抗M型化社會趨勢，理出親子富未來趁早金錢教育Ｘ釐清理財迷思Ｘ小資家庭投資法，像很多知識一樣，財商可以透過後天的學習來改變，不只要學如何賺錢存錢，更要學管理金錢與分配資源。\n'),(10,14,' 陳重銘',0.7,'不必花太多時間，也不必學會高深的理論，採用「隨便買、隨時買、不要賣」的傻瓜投資策略，用定期定額的方式每年買進1張，就算每年都買在最高價，持續10年至少可以獲得18%的正報酬。\n\n　　有紀律地持續買進，領到的股利持續滾入，堅持長期投資，不斷地累積張數。只要持有的股票張數夠多，就算將來只有領股利，也可以達到財務自由，提早退休。\n買進0056，不用擔心股災、不需要研究產業趨勢、不用看公司的財報。只要穩穩地存，報酬率就會遠勝定存，而且還不用擔心股票變壁紙，這就是它的「防守性」。低進高出賺價差，創造更高的報酬，是它的「攻擊性」。即使被套牢了，一樣可以抱股領股利，只要有紀律地在低價時多買一點，就會有解套、賺價差的一天，這就是「可攻可守」。\n投資股票，重點在於選擇一個正確的遊戲方法去投入，如果專注在炒短線、做當沖，只會陷入「負和」的困境，除非你真的是高人一等、萬中無一，不然遲早輸光。但是如果能夠從產業前景、公司競爭力等方面著手，挑出1家好公司來長期投資，就能進入到「正和」遊戲中，報酬將源源不絕，還可以靠複利累積出巨大的財富。\n',0,'我用1檔ETF存自己的18%',360,'2019-06-18','金尉',150,'商業理財','我用1檔ETF存自己的.jpg','投資股票，重點在於選擇一個正確的遊戲方法去投入，如果專注在炒短線、做當沖，只會陷入「負和」的困境，除非你真的是高人一等、萬中無一，不然遲早輸光。'),(11,10,'林則行 ',0.79,'你是選到第一？還是買到唯一？\n業界第一往往落入削價競爭，股價漲幅經常比業界第二名遜色。\n你要買的是擁有獨家技術或服務、能在競爭中獲得壓倒性勝利的公司。\n你買的是潮流股？還是流行股？\n潮流股不管經濟是否景氣，都無法避免上漲的趨勢。\n而流行股雖然能博得一時人氣，但是失敗率通常很高。你能分辨嗎？\n轉虧為盈的公司是「天上掉下來的禮物」，你可以撿到便宜。\n業績成長15% 的小公司，比起成長5% 的大公司股價更容易上漲。\n不過，若這轉虧為盈是來自於合併或重組，效益不會維持太久。',0,'飆股的長相',380,'2022-04-30','大是文化 ',50,'商業理財','飆股的長相.jpg','同樣看K線，飆股的長相跟一般股票哪裡不一樣？\n有沒有辦法比別人早一步看出，「就是這支股票」？\n日本K線大師林則行，用一張K線圖、五個步驟，篩選出真正的大飆股！\n再以「兩段式上漲」，準確預測高點；'),(12,35,'橫山光昭',0.9,'住公司附近，省通勤費但房租高；跟上班通勤但住家遠，你怎麼選？\n◎投資自己很重要，所以買了健身課程、高爾夫球課……其實這些最容易浪費錢。\n◎「請問你，昨天一共花了多少錢？」你只能大概、還是能精確回答？\n薪水永遠追不上物價，我還有可能提早財富自由嗎？\n當然，只要你現在開始培養「有錢體質」。作者橫山光昭學的是會計，卻被公司派到門市當業務，因此他只待了幾年就離職，準備代書考試。當時的他才25歲，有兩個小孩要養，家裡卻只有他一份薪水。',0,'養成有錢體質',360,'2021-04-27','大是文化',25,'商業理財','養成有錢體質.jpg','住公司附近，省通勤費但房租高；跟上班通勤但住家遠，你怎麼選？\n◎投資自己很重要，所以買了健身課程、高爾夫球課……其實這些最容易浪費錢。\n◎「請問你，昨天一共花了多少錢？」你只能大概、還是能精確回答？'),(13,49,'林子揚',0.79,'本書作者長期投資美國優秀企業過去25年只有4年是負報酬，年化報酬率高達25.37%他在2019年度獲利73%，2020年度獲利83%！他是沒有富爸爸、沒有幕後金主、沒有金融財務背景的科技業大叔憑藉科技本業的能力圈及研究功力並遵循著名價值投資大師、成長股大師已成功驗證過的投資心法將資金長年投資於美國企業蘋果（AAPL）、威士卡（V）、微軟（MSFT）、字母（GOOG、GOOGL）、臉書（FB）、萬士達卡（MA）、亞馬遜（AMZN）、阿里巴巴（BABA）等績優股核心持股部位皆享有數倍報酬對於產業趨勢有獨到眼光的他，也成功挖掘並投資新崛起的新創公司如電商Shopify（SHOP）、金融科技的Square（SQ）與PayPal（PYPL）等持股時間不到5年，累積報酬率都是500%起跳',NULL,'超級成長股投資法則',450,'2021-04-28','Smart智富',79,'商業理財','超級成長股投資法則.jpg','每次投資只想短線賺15%、20%就落跑？\n這樣做永遠賺不到大錢\n要讓身價長期跳躍式成長\n就得用對方法，抱對獲利翻倍再翻倍的超級成長股'),(14,4,'Heath Chip',0.5,'Understanding numbers is essential—but humans aren’t built to understand them. Until very recently, most languages had no words for numbers greater than five—anything from six to infinity was known as “lots.” While the numbers in our world have gotten increasingly complex, our brains are stuck in the past. How can we translate millions and billions and milliseconds and nanometers into things we can comprehend and use?Author Chip Heath has excelled at teaching others about making ideas stick and here, in Making Numbers Count, he outlines specific principles that reveal how to translate a number into our brain’s language. This book is filled with examples of extreme number makeovers, vivid before-and-after examples that take a dry number and present it in a way that people click in and say “Wow, now I get it!”',1,'Making Numbers Count',840,'2022-01-11','Avid Reader Press',10,'商業理財','Making Numbers Count.jpg','A clear, practical, first-of-its-kind guide to communicating and understanding numbers and data—from bestselling business author Chip Heath.'),(15,2,' Fisher Roger',0.79,'Getting to Yes has helped millions of people learn a better way to negotiate. One of the primary business texts of the modern era, it is based on the work of the Harvard Negotiation Project, a group that deals with all levels of negotiation and conflict resolution.\n\nGetting to Yes offers a proven, step-by-step strategy for coming to mutually acceptable agreements in every sort of conflict. Thoroughly updated and revised, it offers readers a straight- forward, universally applicable method for negotiating personal and professional disputes without getting angry-or getting taken.',NULL,'Getting to Yes: Negotiating Agreement Without Giving in',595,'2011-05-03','Penguin Books',50,'商業理財','Getting to Yes.jpg','Getting to Yes has helped millions of people learn a better way to negotiate. One of the primary business texts of the modern era, it is based on the work of the Harvard Negotiation Project, a group that deals with all levels of negotiation and conflict resolution.'),(16,29,'林慶旺',0.84,'◢每天睡7小時是最佳睡眠時間\n2021年9月，日本國家癌症中心（National Cancer Center）一項進行14年，參與人數超過32萬人，針對東北亞國家所做的大型睡眠追蹤調查發現，每天睡7小時是最佳睡眠時間，死亡率最低，其他的睡眠時間會增加死亡的風險。\n◢影響睡眠是否良好的主要原因──睡眠的模式\n睡眠是否良好，在於睡眠的模式。所謂睡眠的模式，就是你要能夠充分領悟到陽光、溫度、晝夜節律、褪黑激素、光照度、90分鐘睡眠週期這些因素，才是讓你夜夜擁有優質睡眠的天然「安眠藥 」。白天必須充分曝曬陽光，吸收更多的陽光，夜晚盡量減少光照度，大腦的松果體才能夠正常順利的分泌褪黑激素，讓人體獲得深層睡眠。\n◢18位創意天才的睡眠黃金法則，睡眠是創意源源不斷的來源\n成功靠創意，創意靠睡眠。許多你我所熟知的創意天才貝多芬、柴可夫斯基、達爾文、康德、狄更斯、雨果、福樓拜、佛洛伊德、海明威、畢卡索、村上春樹等等，都熟知其中的奧妙，每天至少都曝曬陽光1小時以上，為了就是一夜好眠；微軟創辦人比爾．蓋茲、電商龍頭亞馬遜創辦人傑夫．貝佐斯，每晚睡前都要幫忙做家事，洗洗碗、陪家人聊天，放鬆身心，為了也是一夜好眠。\n',0,'不懂睡眠就失眠',380,'2022-04-06','時報出版',20,'醫療保健','不懂睡眠就失眠.jpg','夜夜好眠，取決於一開始入眠的90分鐘！\n早上8～12點之間接受陽光刺激的人，夜晚平均花18分鐘就能睡著。\n越理解睡眠，就越容易入睡；只要遵循睡眠模式，讓你夜夜不失眠！'),(17,28,'傑西．謝爾',0.79,'從紙牌、棋子、桌遊、電玩，到近年來火紅的實境遊戲，遊戲一直是人們生活的一部分。我們休閒時玩，學習時玩，甚至連工作場所都在談遊戲化，但「遊戲」的本質到底是什麼？人類為何要演化出沉迷於遊戲的天性？更重要的是，為什麼有的遊戲讓我們玩得無法自拔，有的卻讓人興致缺缺？\n\n　　高明的遊戲設計師都知道，遊戲的目的在於創造體驗，玩家所有感官接收到的外在訊息與心中產生的內在情感和記憶，綜合起來形成的整體體驗，就是遊戲的魔力所在。在程式、立繪、3D建模出爐之前，遊戲設計師是否確立了能讓人共感的主題、是否站在玩家的角度考慮過所有感官刺激與心理機制、是否設定足夠疊代程序與試玩雛型，就已決定了一款遊戲能不能讓玩家頻頻說出「再一場就去睡」，卻總是無法停下手來。\n　　身為玩家，了解開發者使用的機制，就能提升自己與遊戲的同步率，感受最完整的樂趣。身為遊戲開發者，掌握所有能構築體驗的多種元素，才能做出讓人愛不釋手的遊戲。但是翻遍市面上各種攻略和工具書，我們獨缺一本切中遊戲設計原理的指引。《遊戲設計的藝術》自從出版以來，迅速席捲歐美澳各大數位多媒體與遊戲設計學界與產業界，正是因為補上了這個長年缺口。',0,'遊戲設計的藝術',990,'2021-05-12','大家出版',18,'藝術設計','遊戲設計的藝術.jpg','每個好遊戲，一定都是好概念配上好體驗\n全美頂尖遊戲設計師教你設定主題、打造體驗、善用興趣曲線，\n深度了解遊戲運作機制，獲得最完整的遊戲體驗、開發遊戲性絕佳的作品'),(18,45,'羅寶鴻',0.79,'用愛蒙特梭利，正向陪伴，以同理與覺察安定孩子與自己的內在。從理論到方法，從孩子內在發展、有效溝通到情緒自由，\n寶鴻老師教你如何教養孩子不NG，親子關係大提升！\n寶鴻老師身為蒙特梭利專家、同時也是一個小男孩的爸爸，除了堅實的理論基礎外，透過粉專經營，累積大量與爸爸媽媽線上討論教養疑問的經驗，同時也在日常教學中，閱「孩」無數，是爸媽在教養路上，最信賴又溫暖的好夥伴。\n不論你的孩子是學齡前或是小學生，各種教養困擾，都能在這本書找到解方',0,'羅寶鴻的安定教養學',420,'2020-01-15','親子天下',34,'親子教養','羅寶鴻的安定教養學.jpg','用愛蒙特梭利，正向陪伴，以同理與覺察安定孩子與自己的內在。從理論到方法，從孩子內在發展、有效溝通到情緒自由，寶鴻老師教你如何教養孩子不NG，親子關係大提升！'),(19,400,'小歐',0.79,'基隆人小歐，自幼生長於面海的一棟日式老建築中，一切只覺理所當然，不以為意；長大搬離後，才益發意識到這棟「基隆要塞司令官邸」的非比尋常。原本她和不少基隆人一樣，有著「很會去台北」的「邊緣症候群」；直到經歷開啟她人生新章的「四國遍路」後，小歐才踏出與故鄉重新連結的第一步。\n透過走路，她和基隆共享時間，一步步內化這塊生活版圖的風土，也因此發現：基隆原本就很適合散步──山海之間，有許多約五公里、九十分鐘內可走訪的美好風景組合與變化！\n當小歐和故鄉的關係逐漸從疏離走向親密，奇幻的事同時發生了：已經老壞的舊家「基隆要塞司令官邸」，居然得以重生，再現基隆！她因此深感這塊土地上人與物的無限可能。如今，小歐非常享受基隆源源不絕的「好玩」，並寫成本書，與你分享她的舊家記憶與漫步路線，以及在地生活「剛剛好」的幸福。',0,'正好住基隆',400,'2022-03-30','木馬文化',25,'旅遊飲食','正好住基隆.jpg','基隆人小歐，自幼生長於面海的一棟日式老建築中，一切只覺理所當然，不以為意；長大搬離後，才益發意識到這棟「基隆要塞司令官邸」的非比尋常。原本她和不少基隆人一樣，有著「很會去台北」的「邊緣症候群」；直到經歷開啟她人生新章'),(20,25,'Ashley Stahl',0.79,'艾希莉原本是一個沒沒無聞的25歲女孩，剛從倫敦國王學院研究所名校畢業的她，運用高超的人脈建立技巧，一舉從助理攀升成為五角大廈反恐主管。然而她卻發現，在國防部的每一天都讓她度日如年。\n\n　　一次演習意外，身心俱疲的她決心辭職返鄉。就在此時，發現自己的天賦，決心投入網路授課事業。短時間內年營業額竟高達500萬美金！\n\n　　這下，年輕的她，白富美，站在人生高峰上。但她每天睡不到幾小時，也忘記自己身處何處。一個思慮不周的決策，艾希莉的事業迅速垮台，她不但房子被查封、車子、名牌包淪為拍賣，團隊即將解散，全身上下負債累累……\n\n　　然而，現在的她不但兩度登上全世界最知名的TEDx舞台演講！《富比士》邀請她開設職涯專欄，《華爾街日報》、CBS、《華盛頓郵報》、《芝加哥論壇報》等媒體爭相報導她。\n\n　　艾希莉從谷底崛起，她已是世界知名千禧世代職涯訓練專家。\n\n　　到底，她發現了什麼人生真義，又做對了什麼？為什麼，她總是能抓緊人生轉彎的方向盤，在每次巨變後，還能再創巔峰？',1,'別做熱愛的事，要做真實的自己',450,'2022-01-27','商業周刊',21,'心理勵志','別做熱愛的事，要做真實的自己.jpg','她如何從一個小小的廣告助理，成為美國五角大廈的專案主管？又是什麼樣的契機，讓她開創了營業額500萬美金的網路事業？正當她以為走上成功人生道路時，卻因錯誤的決策'),(21,50,'羅杰晟',0.79,'職業安全衛生管理乙級自110年起，考試方式改制為電腦測驗方式。以往的筆試題目會有墨水及擦邊球的給分，出題方式有時也會有貼近實務或近期的重大職災案例讓考生有個準備的方向。而現在為電腦隨機抽選條文，會讓考生難以掌握到出題的方向，甚至會出一些實際上從事安全衛生管理時才會遇到的時事題，讓考生難以作答。但在電腦測驗的方式下，「法規條文」依然為出題的核心方向，「專業課程」與「計畫管理」，則是對法規理解程度去靈活運用技巧，故如何正確的準備考試方向即為取證的利器。',0,'職業安全衛生管理乙級技術士',630,'2022-04-15','千華數位',27,'考試用書','職業安全衛生管理乙級技術士.jpg','職業安全衛生管理乙級自110年起，考試方式改制為電腦測驗方式。以往的筆試題目會有墨水及擦邊球的給分，出題方式有時也會有貼近實務或近期的重大職災案例讓考生有個準備的');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitem`
--

use heroku_596fd9c4945818e;

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `cartitem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nextbuy` bit(1) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `book_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `total` bigint DEFAULT NULL,
  `subtotal` bigint DEFAULT NULL,
  `member_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbws5dqok8cle0jdwfnuetbf4t` (`book_id`),
  KEY `FKhthv3j4uxu0xwqlhcj1xeyw71` (`order_id`),
  KEY `FKricrm2loo0vr5cdai8c4cnadj` (`member_id`),
  CONSTRAINT `FKbws5dqok8cle0jdwfnuetbf4t` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKhthv3j4uxu0xwqlhcj1xeyw71` FOREIGN KEY (`order_id`) REFERENCES `orderr` (`id`),
  CONSTRAINT `FKricrm2loo0vr5cdai8c4cnadj` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8  COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
INSERT INTO `cartitem` VALUES (3,_binary '\0',332,1,5,NULL,NULL,NULL,NULL),(4,_binary '\0',300,1,1,NULL,NULL,NULL,NULL),(5,_binary '\0',221,1,7,NULL,NULL,NULL,NULL),(6,_binary '\0',638,50,4,NULL,NULL,31900,NULL),(7,_binary '\0',300,2,1,NULL,NULL,600,NULL),(9,_binary '\0',300,1,1,2,NULL,300,NULL),(10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,_binary '\0',525,2,6,2,NULL,1050,NULL),(13,_binary '\0',332,1,5,NULL,NULL,332,2),(14,_binary '\0',332,1,5,NULL,NULL,332,NULL),(15,_binary '\0',332,1,5,NULL,NULL,332,NULL),(25,_binary '\0',300,10,1,3,NULL,3000,NULL),(26,_binary '\0',638,1,4,4,NULL,638,NULL),(27,_binary '\0',638,2,4,5,NULL,1276,NULL),(28,_binary '\0',300,1,1,6,NULL,300,NULL),(29,_binary '\0',300,1,1,7,NULL,300,NULL),(30,_binary '\0',300,7,1,8,NULL,2100,NULL),(33,_binary '\0',638,5,4,9,NULL,3190,NULL),(34,_binary '\0',221,1,7,10,NULL,221,NULL),(35,_binary '\0',300,1,1,11,NULL,300,NULL),(46,_binary '\0',319,1,16,15,NULL,319,NULL),(47,_binary '\0',319,1,16,12,NULL,319,NULL),(48,_binary '\0',300,1,11,13,NULL,300,NULL),(49,_binary '\0',300,1,11,14,NULL,300,NULL),(53,_binary '\0',300,1,11,16,NULL,300,NULL),(54,_binary '\0',300,1,11,NULL,NULL,300,2),(55,_binary '\0',300,1,11,17,NULL,300,NULL),(57,_binary '\0',319,1,16,23,NULL,319,NULL),(58,_binary '\0',356,1,13,23,NULL,356,NULL),(59,_binary '\0',300,1,11,26,NULL,300,NULL),(60,_binary '\0',300,1,11,27,NULL,300,NULL),(61,_binary '\0',319,1,16,28,NULL,319,NULL),(62,_binary '\0',300,2,11,29,NULL,600,NULL),(63,_binary '\0',300,1,11,30,NULL,300,NULL),(76,_binary '\0',300,1,11,31,NULL,300,NULL),(77,_binary '\0',319,1,16,31,NULL,319,NULL),(79,_binary '\0',300,2,11,NULL,NULL,600,14);
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

use heroku_596fd9c4945818e;

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `score` int DEFAULT NULL,
  `book_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkko96rdq8d82wm91vh2jsfak7` (`book_id`),
  CONSTRAINT `FKkko96rdq8d82wm91vh2jsfak7` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

use heroku_596fd9c4945818e;

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `shopping_money` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8  COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'1995-03-19','ga13234624@gmail.com','頭份市','0919029219','王俐婷','ga13234624',19),(2,'1993-03-17','sho123520@gmail.com','彰化縣埔鹽鄉','0979516598','Zach','123520',0),(3,'2000-08-07','1234567@gmail.com','頭份市八德一路305巷','0919029542','Abi','1234567',0),(4,'1987-09-25','987654@gmail.com','苗栗市','0958456763','Amy','987654',0),(5,'2022-04-24','1111@gmail','頭份市八德一路305巷','0979516598','Sammy','111111111',0),(6,'2022-04-24','1111@gmail.com','頭份市八德一路305巷','0923456789','Sammy','123456789',0),(7,'2022-04-04','987654111@gmail.com','彰化縣埔鹽鄉','0919456786','Kristine','0123456789',0),(8,'2022-04-01','1234567890@gmail.com','','0979516598','葉小新','123456789',0),(9,'2022-04-07','abcdefgh@gmail','','0911111111','張小可','abcdefgh',0),(10,'2022-03-29','aaaaaaaa@gmail','','0912345678','蕭渣某','aaaaaaaa',0),(11,'2021-12-02','bbbbbbbb@gmail','','0999999999','Abi','bbbbbbbb',0),(12,'2020-01-28','cccccccc@gmail','','0912345678','Zach','cccccccc',0),(13,'2022-03-28','dddddddd@gmail','','0911111111','Zach','dddddddd',0),(14,'1993-03-17','sho123520_myBook@gmail.com','頭份市八德一路305巷','0979516598','Zach Lin',')P:?4rfv',0);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderr`
--

use heroku_596fd9c4945818e;

DROP TABLE IF EXISTS `orderr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `orderr` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `datetime` datetime(6) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `receiver_phone` varchar(255) DEFAULT NULL,
  `reciver_address` varchar(255) DEFAULT NULL,
  `total` bigint DEFAULT NULL,
  `member_id` bigint DEFAULT NULL,
  `shoppingmoney` bigint DEFAULT NULL,
  `offset` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcinsngk7n1vj3baxdwcjv8o6m` (`member_id`),
  CONSTRAINT `FKcinsngk7n1vj3baxdwcjv8o6m` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8  COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderr`
--

LOCK TABLES `orderr` WRITE;
/*!40000 ALTER TABLE `orderr` DISABLE KEYS */;
INSERT INTO `orderr` VALUES (1,'2022-03-09 10:47:16.449694','王俐婷','0919029219','彰化縣永靖鄉',1350,1,13,NULL),(2,'2022-01-09 10:49:13.733545','王俐婷','0919029219','彰化縣永靖鄉',1350,1,13,NULL),(3,'2021-10-09 11:10:24.922944','王俐婷','0919029219','彰化縣永靖鄉',3000,1,NULL,NULL),(4,'2022-04-09 11:12:26.339119','王俐婷','0919029219','彰化縣永靖鄉',698,1,NULL,NULL),(5,'2022-04-09 11:15:30.782486','王俐婷','0919029219','彰化縣永靖鄉',1276,1,NULL,NULL),(6,'2022-04-09 11:18:42.585028','王俐婷','0919029219','彰化縣永靖鄉',360,1,NULL,NULL),(7,'2022-04-09 11:21:45.362705','王俐婷','0919029219','彰化縣永靖鄉',360,1,NULL,NULL),(8,'2022-04-09 12:35:17.740667','王俐婷','0919029219','彰化縣永靖鄉',2100,1,NULL,NULL),(9,'2022-04-12 18:18:56.859679','王俐婷','0919029219','彰化縣永靖鄉',3190,1,NULL,NULL),(10,'2022-04-12 18:19:56.705783','王俐婷','0919029219','彰化縣永靖鄉',281,1,NULL,NULL),(11,'2022-04-12 18:20:44.807302','王俐婷','0919029219','彰化縣永靖鄉',360,1,NULL,NULL),(12,'2022-04-26 17:17:04.123058','王俐婷','0911111111','頭份市',379,1,3,NULL),(13,'2022-04-26 17:21:12.171647','王俐婷','0911111111','頭份市',360,1,3,NULL),(14,'2022-04-26 18:13:53.816390','王俐婷','0911111111','頭份市',355,1,2,5),(15,'2022-04-26 20:14:05.385504','王俐婷','0919029219','頭份市',378,1,3,1),(16,'2022-04-27 14:54:11.271272','王俐婷','0919029219','頭份市',360,1,3,0),(17,'2022-04-27 15:04:32.490496','王俐婷','0919029219','頭份市',360,1,3,0),(18,'2022-04-27 15:39:16.532037','王俐婷','0919029219','頭份市',795,1,7,0),(23,'2022-04-27 16:00:12.067043','王俐婷','0919029219','頭份市',735,1,6,0),(26,'2022-04-27 16:06:07.548106','王俐婷','0919029219','頭份市',340,1,2,20),(27,'2022-04-27 16:08:44.846326','王俐婷','0919029219','頭份市',360,1,3,0),(28,'2022-04-27 16:19:27.567830','王俐婷','0919029219','頭份市',377,1,3,2),(29,'2022-04-27 16:20:37.782028','王俐婷','0919029219','頭份市',659,1,5,1),(30,'2022-04-27 16:22:39.467703','王俐婷','0919029219','頭份市',360,1,3,0),(31,'2022-04-30 12:36:01.557973','王俐婷','0919029219','頭份市',679,1,6,0);
/*!40000 ALTER TABLE `orderr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reorder`
--

use heroku_596fd9c4945818e;

DROP TABLE IF EXISTS `reorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `reorder` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `datetime` datetime(6) DEFAULT NULL,
  `book_id` bigint DEFAULT NULL,
  `member_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKefxlmnif575017ljytq2v2kkd` (`book_id`),
  KEY `FKrtoe55pt7imwlhwhg80p5g2da` (`member_id`),
  CONSTRAINT `FKefxlmnif575017ljytq2v2kkd` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKrtoe55pt7imwlhwhg80p5g2da` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8  COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reorder`
--

use heroku_596fd9c4945818e;

LOCK TABLES `reorder` WRITE;
/*!40000 ALTER TABLE `reorder` DISABLE KEYS */;
INSERT INTO `reorder` VALUES (6,'2022-04-27 10:29:27.311986',4,2),(7,'2022-04-27 10:45:26.451270',4,1);
/*!40000 ALTER TABLE `reorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-30 17:09:52
