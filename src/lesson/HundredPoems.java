package lesson;

public class HundredPoems {
	
	public static String setPlayerName() {
		String name;
		while (true) {
			name = MyConsole.readLine();
			if (!name.equals("")) {
				break;
			}
			System.out.println("名前を入力してください");
		}
		return name;
	}

	public static void main(String[] args) {
	
		String[] abovePhrase = {
			    "秋の田のかりほの庵の苫をあらみ",
			    "春過ぎて夏来にけらし白妙の",
			    "あしびきの山鳥の尾のしだり尾の",
			    "田子の浦にうちいでて見れば白妙の",
			    "奥山にもみぢふみわけなく鹿の",
			    "かささぎの渡せる橋におく霜の",
			    "天の原ふりさけ見れば春日なる",
			    "わが庵は都のたつみしかぞすむ",
			    "花の色はうつりにけりないたづらに",
			    "これやこの行くも帰るもわかれては",
			    "わたの原八十島かけてこぎいでぬと",
			    "天つ風雲のかよい路吹きとぢよ",
			    "つくばねの峰よりおつるみなの川",
			    "みちのくのしのぶもぢずり誰ゆゑに",
			    "君がため春の野にいでて若菜つむ",
			    "立ちわかれいなばの山の峰に生ふる",
			    "ちはやぶる神代もきかず竜田川",
			    "すみの江の岸に寄る波よるさへや",
			    "難波潟みじかき芦のふしのまも",
			    "わびぬればいまはたおなじ難波なる",
			    "いまこむといひしばかりに長月の",
			    "吹くからに秋の草木のしをるれば",
			    "月みればちぢに物こそかなしけれ",
			    "このたびはぬさもとりあへず手向山",
			    "名にしおはば逢坂山のさねかづら",
			    "小倉山峰のもみぢば心あらば",
			    "みかの原わきて流れるるいづみ川",
			    "山里は冬ぞさびしさまさりける",
			    "心あてに折らばや折らむ初霜の",
			    "ありあけのつれなく見えし別れより",
			    "朝ぼらけありあけの月と見るまでに",
			    "山川に風のかけたるしがらみは",
			    "ひさかたの光のどけき春の日に",
			    "誰をかもしる人にせむ高砂の",
			    "人はいさ心もしらずふるさとは",
			    "夏の夜はまだ宵ながら明けぬるを",
			    "白露に風の吹きしく秋の野は",
			    "忘らるる身をば思はずちかひてし",
			    "浅茅生の小野の篠原しのぶれど",
			    "しのぶれど色にいでにけりわが恋は",
			    "恋すてふわが名はまだき立ちにけり",
			    "ちぎりきなかたみに袖をしぼりつつ",
			    "あひみてののちの心にくらぶれば",
			    "あふことのたえてしなくはなかなかに",
			    "あはれともいふべき人は思ほえで",
			    "由良のとをわたる舟人かぢをたえ",
			    "八重むぐらしげれる宿のきびしきに",
			    "風をいたみ岩うつ波のおのれのみ",
			    "みかきもり衛士のたく火の夜はもえ",
			    "君がため惜しからざりしいのちさへ",
			    "かくとだにえやはいぶきのさしも草",
			    "あけぬれば暮るるものとはしりながら",
			    "なげきつつひとりぬる夜のあくるまは",
			    "忘れじのゆくすゑまではかたければ",
			    "滝の音はたえて久しくなりぬれど",
			    "あらざらむこの世のほかの思ひ出に",
			    "めぐりあひてみしやそれともわかぬまに",
			    "ありま山ゐなの笹原風吹けば",
			    "やすらはで寝なましものをさ夜ふけて",
			    "大江山いく野の道の遠ければ",
			    "いにしへの奈良の都の八重桜",
			    "夜をこめて鳥のそらねははかるとも",
			    "いまはただ思ひ絶えなむとばかりを",
			    "朝ぼらけ宇治の川霧たえだえに",
			    "うらみわびほさぬ袖だにあるものを",
			    "もろともにあはれと思へ山桜",
			    "春の夜のゆめばかりなる手枕に",
			    "こころにもあらでうき世にながらへば",
			    "あらしふく三室の山のもみぢばは",
			    "さびしさに宿をたちいでてながむれば",
			    "夕されば門田の稲葉おとづれて",
			    "音にきくたかしの浜のあだ波は",
			    "高砂のをのへの桜咲きにけり",
			    "憂かりける人を初瀬の山おろしよ",
			    "ちぎりおきしさせもが露をいのちにて",
			    "わたの原こぎいでてみれば久方の",
			    "瀬をはやみ岩にせかるる滝川の",
			    "淡路島かよふ千鳥のなく声に",
			    "秋風にたなびく雲のたえ間より",
			    "長からむ心もしらず黒髪の",
			    "ほととぎす鳴きつる方をながむれば",
			    "思ひわびさてもいのちはあるものを",
			    "世の中よ道こそなけれ思ひ入る",
			    "ながらへばまたこのごろよやしのばれむ",
			    "夜もすがら物思ふころは明けやらで",
			    "なげけとて月やは物を思はする",
			    "村雨の露もまだひぬまきの葉に",
			    "難波江の芦のかりねのひとよゆゑ",
			    "玉のをよたえなばたえねながらへば",
			    "見せばやな雄島のあまの袖だにも",
			    "きりぎりす鳴くや霜夜のさむしろに",
			    "わが袖は潮干にみえぬ沖の石の",
			    "世の中はつねにもがもななぎさこぐ",
			    "み吉野の山の秋風さ夜ふけて",
			    "おほけなくうき世の民におほふかな",
			    "花さそふ嵐の庭の雪ならで",
			    "こぬ人をまつほの浦の夕なぎに",
			    "風そよぐならの小川の夕ぐれは",
			    "人もをし人もうらめしあぢきなく",
			    "ももしきやふるき軒ばのしのぶにも"
			};

			String[] lowerPhrase = {
			    "わが衣手は露にぬれつつ",
			    "衣ほすてふ天の香具山",
			    "ながながし夜をひとりかも寝む",
			    "富士の高嶺に雪は降りつつ",
			    "声聞く時ぞ秋はかなしき",
			    "白きを見れば夜ぞふけにける",
			    "三笠の山にいでし月かも",
			    "よをうぢ山と人はいふなり",
			    "わが身よにふるながめせしまに",
			    "知るも知らぬもあふ坂の関",
			    "人には告げよあまのつり船",
			    "をとめの姿しばしとどめむ",
			    "恋いぞつもりて淵となりぬる",
			    "乱れそめにしわれならなくに",
			    "わが衣手に雪はふりつつ",
			    "まつとし聞かば今帰り来む",
			    "からくれなゐに水くくるとは",
			    "夢のかよひ路人めよくらむ",
			    "あはでこの世をすぐしてよとや",
			    "みをつくしてもあはむとぞ思ふ",
			    "ありあけの月を待ちいでつるかな",
			    "むべ山風を嵐といふうらむ",
			    "わが身ひとつの秋にはあらねど",
			    "もみぢのにしき神のまにまに",
			    "人にしられで来るよしもがな",
			    "いまひとたびのみゆき待つたなむ",
			    "いつみきとてか恋しかるらむ",
			    "人めも草もかれぬと思へば",
			    "おきまどはせる白菊の花",
			    "あかつきばかりうきものはなし",
			    "吉野の里にふれる白雪",
			    "ながれもあへぬもみぢなりけり",
			    "しづ心なく花のちるらむ",
			    "松も昔の友ならなくに",
			    "花ぞ昔の香ににほひける",
			    "雲のいづこに月やどるらむ",
			    "つらぬきとめぬ玉ぞ散りける",
			    "人のいのちの惜しくもあるかな",
			    "あまりてなどか人の恋しき",
			    "物や思ふと人のとふまで",
			    "人知れずこそ思ひそめしか",
			    "末の松山波こさじとは",
			    "昔は物を思わざりけり",
			    "人をも身をも恨みざらまし",
			    "身のいたづらになりぬべきかな",
			    "ゆくへも知らぬ恋の道かな",
			    "人こそ見えね秋は来にけり",
			    "くだけて物を思ふころかな",
			    "昼は消えつつ物をこそ思へ",
			    "長くもがなと思ひけるかな",
			    "さしもしらじなもゆる思ひを",
			    "なほうらめしき朝ぼらけかな",
			    "いかに久しきものとかはしる",
			    "今日をかぎりのいのちともがな",
			    "名こそ流れてなほ聞こえけれ",
			    "いまひとたびのあふこともがな",
			    "雲がくれにし夜半の月かな",
			    "いでそよ人を忘れやはする",
			    "かたぶくまでの月を見しかな",
			    "まだふみも見ず天の橋立",
			    "けふ九重ににほいぬるかな",
			    "よに逢坂の関はゆるさじ",
			    "人ずてならで言ふよしもがな",
			    "あわはれわたる背々の網代木",
			    "恋にくちなむ名こそをしけれ",
			    "花よりほかにしる人もなし",
			    "かひなくたたむ名こそをしけれ",
			    "恋しかるべき夜半の月かな",
			    "竜田の川の錦なりけり",
			    "いづこもおなじ秋の夕ぐれ",
			    "芦のまろやに秋風ぞ吹く",
			    "かけじや袖のぬれもこそすれ",
			    "外山のかすみたたずもあらなむ",
			    "はげしかれとは祈らぬものを",
			    "あはれ今年のあきもいぬめり",
			    "雲ゐにまがふ沖つ白波",
			    "われても末にあはむとぞ思う",
			    "幾夜ねざめぬ須磨の関守",
			    "もれいづる月のかげのさやけさ",
			    "みだれてけさはものをこそ思へ",
			    "ただありあけの月ぞ残れる",
			    "憂きにたへぬは涙なりけり",
			    "山の奥にも鹿ぞ鳴くなる",
			    "憂しと見し世ぞ今は恋しき",
			    "閨のひまさへつれなかりけり",
			    "かこち顔なるわが涙かな",
			    "霧たちのぼる秋の夕ぐれ",
			    "みをつくしてや恋ひわたるべき",
			    "忍ぶることの弱りもぞする",
			    "ぬれにぞぬれし色はかはらず",
			    "衣かたしきひとりかも寝む",
			    "人こそしらねかわくまもなし",
			    "あまの小舟のつなでかなしも",
			    "ふるさと寒く衣うつなり",
			    "わが立つ杣に墨染めの袖",
			    "ふりゆくものはわが身なりけり",
			    "焼くやもしほの身もこがれつつ",
			    "みそぎぞ夏のしるうしなりける",
			    "世を思ふゆゑに物思ふ身は",
			    "なほあまりある昔なりけり"
			};
			//取り除かれたカードのインデックス、プレイヤーがgetしたカードのペア数
			int[] removeCardIndex = new int[100];
			int countCardsPlayer01Drawn = 0;
			int countCardsPlayer02Drawn = 0;
			
			//プレイヤー名設定
			System.out.println("プレイヤー名1を入力してください");
			String player01Name = setPlayerName();
			System.out.println("プレイヤー名2を入力してください");
			String player02Name = setPlayerName();
			
			//ゲームスタート　どちらかが50枚より多く取るまでLoop
			System.out.println("enterを押してゲームを進めてください");
			while (countCardsPlayer01Drawn <= 50 && countCardsPlayer02Drawn <= 50) {
				//player1のターン
				System.out.println(player01Name + "のターンです。: " + countCardsPlayer01Drawn);
				//上の句をランダムで出力
				System.out.println("上の句は");
				int aboveRandomIndex;
				ChoiseCardLoop: while (true) {
					aboveRandomIndex = (int) (Math.random() * 100);
					for (int i = 0; i <= countCardsPlayer01Drawn + countCardsPlayer02Drawn; i++) {
						if (removeCardIndex[i] != aboveRandomIndex) {
							break ChoiseCardLoop;
						}
					}
				}
				System.out.println(abovePhrase[aboveRandomIndex]);

				//下の句をランダムで出力
				System.out.println("下の句は");
				int lowerRandomIndex;
				ChoiseCardLoop: while (true) {
					lowerRandomIndex = (int) (Math.random() * 100);
					for (int i = 0; i <= countCardsPlayer01Drawn + countCardsPlayer02Drawn; i++) {
						if (removeCardIndex[i] != lowerRandomIndex) {
							break ChoiseCardLoop;
						}
					}
				}
				System.out.println(lowerPhrase[lowerRandomIndex]);
				
				//句が一致しているかチェック
				if (aboveRandomIndex == lowerRandomIndex) {
					removeCardIndex[countCardsPlayer01Drawn + countCardsPlayer02Drawn] = aboveRandomIndex;
					countCardsPlayer01Drawn += 1;
					System.out.println(abovePhrase[aboveRandomIndex] + lowerPhrase[lowerRandomIndex]);
					System.out.println("ペアが揃いました！");
				} else {
					System.out.println("ペアが揃いませんでした");
				}
				//取ったペア数が50で並んだ場合、引き分けでゲーム終了
				if (countCardsPlayer01Drawn == 50 && countCardsPlayer02Drawn == 50) {
					System.out.println("ゲームは引き分けです！");
					break;
				}
				if (countCardsPlayer01Drawn > 50) {
					break;
				}
				
				//player2のターン
				System.out.println(player02Name + "のターンです。: " + countCardsPlayer02Drawn);
				//上の句をランダムで出力
				System.out.println("上の句は");
				ChoiseCardLoop: while (true) {
					aboveRandomIndex = (int) (Math.random() * 100);
					for (int i = 0; i <= countCardsPlayer01Drawn + countCardsPlayer02Drawn; i++) {
						if (removeCardIndex[i] != aboveRandomIndex) {
							break ChoiseCardLoop;
						}
					}
				}
				System.out.println(abovePhrase[aboveRandomIndex]);

				//下の句をランダムで出力
				System.out.println("下の句は");
				ChoiseCardLoop: while (true) {
					lowerRandomIndex = (int) (Math.random() * 100);
					for (int i = 0; i <= countCardsPlayer01Drawn + countCardsPlayer02Drawn; i++) {
						if (removeCardIndex[i] != lowerRandomIndex) {
							break ChoiseCardLoop;
						}
					}
				}
				System.out.println(lowerPhrase[lowerRandomIndex]);
				
				//句が一致しているかチェック
				if (aboveRandomIndex == lowerRandomIndex) {
					removeCardIndex[countCardsPlayer01Drawn + countCardsPlayer02Drawn] = aboveRandomIndex;
					countCardsPlayer02Drawn += 1;
					System.out.println(abovePhrase[aboveRandomIndex] + lowerPhrase[lowerRandomIndex]);
					System.out.println("ペアが揃いました！");
				} else {
					System.out.println("ペアが揃いませんでした");
				}
				
				if (countCardsPlayer01Drawn == 50 && countCardsPlayer02Drawn == 50) {
					System.out.println("ゲームは引き分けです！");
					break;
				}
			}
			
			String msg;
			if (countCardsPlayer01Drawn > countCardsPlayer02Drawn) {
				msg = "player1の勝利！";
			} else {
				msg = "player2の勝利！";
			}
			System.out.println(msg);
	}

}
