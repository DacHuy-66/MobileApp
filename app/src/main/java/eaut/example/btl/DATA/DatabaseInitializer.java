package eaut.example.btl.DATA;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseInitializer {

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ dễ
    public static void addEasyQuestions(SQLiteDatabase db) {
        String[] easyQuestions = {
                //1
                "Đâu là thủ đô của Việt Nam?",
                "Sông nào dài nhất thế giới?",
                "Ai là tác giả của truyện ngắn 'Lão Hạc'?",
                "Tác phẩm nào sau đây của Nam Cao thuộc giai đoạn sáng tác trước Cách mạng tháng Tám?",
                "Tác giả của câu thơ 'Sông Mã xa rồi Tây Tiến ơi!' là ai?",
                "Tập thơ 'Nhật ký trong tù' của Hồ Chí Minh gồm bao nhiêu bài thơ?",
                "Nhân vật nào trong 'Truyện Kiều' của Nguyễn Du được miêu tả là 'người đâu gặp gỡ làm chi, trăm năm biết có duyên gì hay không'?",
                "Hịch tướng sĩ của Trần Hưng Đạo được viết nhằm mục đích gì?",
                "Cuộc khởi nghĩa Hai Bà Trưng diễn ra vào năm nào?",
                "Chiến thắng nào kết thúc hoàn toàn cuộc kháng chiến chống thực dân Pháp (1945 - 1954)?",

                //2
                "Đội quân do vua Lý Thường Kiệt lãnh đạo đã chiến thắng trong trận nào?",
                "Nguyễn Trãi bị xử án 'tru di tam tộc' do liên quan đến vụ án nào?",
                "Triều đại nào có thời gian tồn tại lâu nhất trong lịch sử phong kiến Việt Nam?",
                "Quốc gia nào có diện tích lớn thứ hai thế giới?",
                "Hồ nước ngọt lớn nhất thế giới là hồ nào?",
                "Dãy núi dài nhất thế giới là dãy núi nào?",
                "Sa mạc lớn nhất thế giới là sa mạc nào?",
                "Vùng biển nào được coi là biển nội địa lớn nhất thế giới?",
                "Quốc gia nào có nhiều múi giờ nhất thế giới?",
                "Trong tác phẩm 'Những đứa con trong gia đình' của Nguyễn Thi, hai chị em nào là nhân vật chính?",

                //3
                "Nhà văn nào được gọi là 'ông hoàng của truyện ngắn Việt Nam'?",
                "Tác phẩm nào sau đây của Xuân Quỳnh viết về tình yêu với cuộc đời?",
                "Trong tác phẩm 'Chí Phèo' của Nam Cao, ai là người đã giúp Chí Phèo tìm lại phần lương thiện của mình?",
                "Một con hổ bị xích vào gốc cây, sợi xích dài 30m. Có 1 bụi cỏ cách gốc cây 31m, đố bạn làm sao con hổ ăn được bụi cỏ?",
                "Có 1 con trâu. Đầu nó thì hướng về hướng mặt trời mọc, nó quay trái 2 vòng sau đó quay ngược lại, hỏi cái đuôi của nó chỉ hướng nào?",
                "Loại nước giải khát nào chứa sắt và canxi?",
                "Con gì bỏ cái đuôi thành con ngựa? (Đố mẹo)",
                "Bỏ ngoài nướng trong, ăn ngoài bỏ trong là gì?",
                "Có 1 ông kia đi qua 3 cái hang, cái thứ nhất ông gặp toàn kim cương, hang thứ 2 ông gặp toàn xác chết, hang thứ 3 ông gặp 1 con rồng, hỏi ông tên gì?",
                "Núi nào mà bị chặt ra từng khúc?",

                //4
                "Cây gì rễ tít trên cao, Đứng ở đầu làng, tỏa bóng mát che?",
                "Cửu Long nguồn cội bao đời, Cửa gì yên ổn trước sau, trong ngoài - Là cửa gì?",
                "Nghìn năm thăm thẳm đêm đêm, Một con thác sáng bừng lên muôn vùng - Là sông nào?",
                "Nơi nào có bến Ninh Kiều, Tây Đô sông nước dập dìu khách thương?",
                "Tỉnh nào tiếp giáp đất Miên, Là nơi có núi Bà Đen lâu đời?",
                "Sông nào lạnh lẽo tâm can Chảy qua Đà Nẵng Quảng Nam trung phần?",
                "Sông nào chia cắt nước nhà Hai miền Nam Bắc can qua tương tàn?",
                "Bánh gì không bở, không giòn, Đêm rằm tháng tám đi cùng trung thu - Là bánh gì?",
                "Tuyên ngôn độc lập lần hai, Bình Ngô Đại Cáo của ai hỡi người - Là ai?",
                "Khuôn mặt tuy chẳng đẹp trai, Tài cao học rộng, khó ai sánh bằng, Đi sứ, chức lớn được thăng, Trạng nguyên lưỡng quốc, đời hằng ngợi ca - Là ai?",

                //5
                "Từ trong làn nước xanh trong, Vươn lên sưởi ánh nắng hồng sáng tươi, Nở hoa làm đẹp cho đời, Nghe tên quân giặc rụng rời khiếp kinh - Là cây gì?",
                "Tuyên ngôn độc lập lần đầu, Ai từng lập tuyến sông Cầu, Tống tan - Là ai?",
                "Con gì bay cao thì được, bay thấp thì không?",
                "Quốc gia nào nổi tiếng với các món sushi, sashimi và mì ramen?",
                "Quốc gia nào sau đây nằm ở Châu Mỹ?",
                "Quốc gia nào giành được nhiều danh hiệu FIFA World Cup nhất?",
                "Quốc gia Đông Nam Á nào nổi tiếng với những bãi biển và hòn đảo tuyệt đẹp như Bali và đảo Komodo?",
                "Quốc gia Tây Âu nào nổi tiếng với những cảnh quan tuyệt đẹp, bao gồm Cao nguyên Scotland và hồ Loch Ness?",
                "Quốc gia Tây Âu nào nổi tiếng với cánh đồng hoa tulip, cối xay gió và guốc gỗ?",
                "Quốc gia châu Âu nào được biết đến với lĩnh vực ngân hàng và là nơi đặt trụ sở của nhiều tổ chức tài chính quốc tế?"
        };

        String[][] easyAnswers = {
                //1
                {"Huế", "Hà Nội", "Đà Nẵng", "Sài Gòn"},
                {"Sông Nile", "Sông Amazon", "Sông Hằng", "Sông Mekong"},
                {"Ngô Tất Tố", "Nguyễn Du", "Nam Cao", "Tố Hữu"},
                {"Sống mòn", "Đôi mắt", "Nhật ký ở rừng", "Lão Hạc"},
                {"Huy Cận", "Chế Lan Viên", "Quang Dũng", "Tố Hữu"},
                {"134 bài", "116 bài", "130 bài", "122 bài"},
                {"Từ Hải", "Kim Trọng", "Thúc Sinh", "Sở Khanh"},
                {"Khuyến khích lòng yêu nước", "Kêu gọi sự đoàn kết của dân tộc", "Thúc giục binh sĩ đánh giặc Nguyên - Mông", "Khuyến khích văn chương"},
                {"Năm 80", "Năm 43", "Năm 54", "Năm 40"},
                {"Chiến thắng Đông Khê", "Chiến thắng Biên giới", "Chiến thắng Điện Biên Phủ", "Chiến thắng Việt Bắc"},

                //2
                {"Trận Bạch Đằng", "Trận Rạch Gầm - Xoài Mút", "Trận sông Như Nguyệt", "Trận Ngọc Hồi - Đống Đa"},
                {"Vụ án Thái sư Trần Thủ Độ", "Vụ án Lệ Chi Viên", "Vụ án Hồ Quý Ly", "Vụ án Thượng tướng Trần Quốc Tuấn"},
                {"Triều Lý", "Triều Trần", "Triều Lê", "Triều Nguyễn"},
                {"Hoa Kỳ", "Trung Quốc", "Nga", "Canada"},
                {"Hồ Victoria", "Hồ Superior", "Hồ Baikal", "Hồ Tanganyika"},
                {"Dãy Alps", "Dãy Himalaya", "Dãy Andes", "Dãy Rocky"},
                {"Sa mạc Sahara", "Sa mạc Gobi", "Sa mạc Kalahari", "Sa mạc Namib"},
                {"Biển Đỏ", "Biển Caspian", "Biển Đen", "Biển Baltic"},
                {"Trung Quốc", "Nga", "Hoa Kỳ", "Brazil"},
                {"Mai và Tùng", "Thúy và Kiều", "Lan và Điệp", "Chiến và Việt"},

                //3
                {"Nam Cao", "Thạch Lam", "Nguyễn Công Hoan", "Vũ Trọng Phụng"},
                {"Sóng", "Thuyền và biển", "Tự hát", "Thơ tình cuối mùa thu"},
                {"Bá Kiến", "Thị Nở", "Lý Cường", "Bà Ba"},
                {"Sợi xích giãn ra", "Bụi cỏ được chuyển về chỗ con hổ", "Con hổ không ăn cỏ", "Sợi xích đứt, con hổ chạy tới bụi cỏ"},
                {"Chỉ lên trời", "Chỉ xuống đất", "Chỉ sang trái", "Chỉ sang phải"},
                {"Coca", "Cafe", "Nước khoáng", "Nước dừa"},
                {"Con mèo", "Con thỏ", "Con hổ", "Con chó"},
                {"Củ khoai", "Bánh chưng", "Cà rốt", "Bắp ngô"},
                {"Kim Thạch", "Hoàng Long", "Kim Tử Long", "Ông Ngọc"},
                {"Núi Sơn Trà", "Núi Thái Sơn", "Núi Hồng Lĩnh", "Núi Bạch Mã"},

                //4
                {"Cây Xoài", "Cây Phượng", "Cây Cau", "Cây Đa"},
                {"Cửa Đông", "Cửa Hội", "Cửa Định An", "Cửa Nam"},
                {"Sông Đà", "Sông Hồng", "Sông Mê-Kông", "Sông Cửu Long"},
                {"Khánh Hòa", "Kiên Giang", "Cần Thơ", "Tiền Giang"},
                {"Tây Ninh", "Buôn Mê Thuật", "Đắk Nông", "Đắk Lắk"},
                {"Sông Hồng", "Sông Tiền", "Sông Hàn", "Sông Hậu"},
                {"Sông Bến Hải", "Sông Giang", "Sông Cửu Long", "Sông Bạch Đằng"},
                {"Bánh nướng", "Bánh dẻo", "Bánh bèo", "Bánh bò"},
                {"Lý Thường Kiệt", "Quang Trung", "Nguyễn Ánh", "Nguyễn Trãi"},
                {"Nguyễn Bỉnh Khiêm", "Mạc Đỉnh Chi", "Phùng Khắc Khoan", "Nguyễn Trực"},

                //5
                {"Cây trúc", "Cây mía", "Cây hoa súng", "Cây lúa"},
                {"Lý Thường Kiệt", "Ngô Quyền", "Trần Hưng Đạo", "Lê Hoàn"},
                {"Con ong", "Con chim", "Con chuồn chuồn", "Con diều"},
                {"Trung Quốc", "Nhật Bản", "Ấn Độ", "Thái Lan"},
                {"Serbia", "Cannada", "Đan Mạch", "Hà Lan"},
                {"Senegal", "Brazil", "Ý", "Argentina"},
                {"Việt Nam", "Indonesia", "Philippines", "Myanmar"},
                {"Ireland", "Vương quốc Anh", "Na Uy", "Đan Mạch"},
                {"Thụy Sĩ", "Áo", "Bỉ", "Hà Lan"},
                {"Vương quốc Anh", "Đức", "Pháp", "Thụy Sĩ"}
        };

        int[] easyCorrectAnswers = {2,1,3,4,3,1,2,3,4,3,  3,2,3,4,2,3,1,2,2,4,  3,3,2,3,2,3,1,4,2,3,  4,3,2,3,1,3,1,2,4,3, 3,1,4,2,2,2,2,2,4,4};
        addQuestionsToDatabase(db, easyQuestions, easyAnswers, easyCorrectAnswers, 1);
    }

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ vừa
    public static void addMediumQuestions(SQLiteDatabase db) {
        String[] mediumQuestions = {
                //1
                "Ai là tác giả của bài thơ 'Tây Tiến'?",
                "'Chữ người tử tù' của Nguyễn Tuân kể về mối quan hệ giữa ai?",
                "Trong 'Tắt đèn' của Ngô Tất Tố, hoàn cảnh nào đã khiến chị Dậu phải bán con?",
                "Nhân vật chính trong tác phẩm 'Người lái đò sông Đà' của Nguyễn Tuân là ai?",
                "Lê Thái Tổ đã lập nên triều đại nào sau khi lãnh đạo khởi nghĩa Lam Sơn thành công?",
                "Ai là người đã lãnh đạo phong trào Cần Vương trong cuộc kháng chiến chống thực dân Pháp?",
                "Hiệp định Genève năm 1954 quy định điều gì về Việt Nam?",
                "Triều đại nào đã áp dụng chế độ 'thân vương' với các thành viên trong hoàng tộc?",
                "Địa danh nào gắn liền với cuộc khởi nghĩa của Trương Định?",
                "Trong kháng chiến chống Pháp, ai là người chỉ huy chiến dịch biên giới thu - đông năm 1950?",

                //2
                "Chiến thắng nào được coi là đòn quyết định để chấm dứt cuộc kháng chiến chống Mỹ?",
                "Năm 1010, ai đã dời đô từ Hoa Lư về Thăng Long?",
                "Cuộc khởi nghĩa nào là khởi đầu cho phong trào chống Pháp ở Bắc Kỳ vào cuối thế kỷ 19?",
                "Ai là người đã ban bố bản 'Chiếu dời đô'?",
                "Quốc gia nào sau đây nằm hoàn toàn ở Nam bán cầu?",
                "Thành phố nào là thủ đô của New Zealand?",
                "Quốc gia nào sau đây không có biên giới trên đất liền?",
                "Sông nào dài nhất thế giới?",
                "Biển nào có nồng độ muối cao nhất thế giới?",
                "Vịnh Hạ Long, Di sản Thiên nhiên Thế giới, thuộc tỉnh nào của Việt Nam?",

                //3
                "Khu du lịch Phong Nha - Kẻ Bàng nổi tiếng với hệ thống hang động hùng vĩ nằm ở tỉnh nào?",
                "Đỉnh Fansipan, được mệnh danh là 'nóc nhà Đông Dương,' thuộc dãy núi nào?",
                "Di tích Cố đô Huế là di sản văn hóa thế giới được UNESCO công nhận vào năm nào?",
                "Thác Bản Giốc, một trong những thác nước lớn và đẹp nhất Việt Nam, nằm trên biên giới giữa Việt Nam và quốc gia nào?",
                "Chùa Một Cột, một trong những biểu tượng của thủ đô Hà Nội, được xây dựng vào thời vua nào?",
                "Hội An, một di sản văn hóa thế giới, nổi tiếng với loại hình nghệ thuật nào?",
                "Đèo Hải Vân được coi là ranh giới tự nhiên giữa hai vùng nào của Việt Nam?",
                "Khu di tích Tràng An, nơi được coi là 'Vịnh Hạ Long trên cạn', nằm ở tỉnh nào?",
                "Địa danh nào ở Đà Nẵng nổi tiếng với những cây cầu treo và các công trình hiện đại trên núi?",
                "Vườn quốc gia Cát Tiên, nổi tiếng với đa dạng sinh học và hệ động thực vật phong phú, nằm chủ yếu ở tỉnh nào?",

                //4
                "Tháp Eiffel, biểu tượng nổi tiếng của nước Pháp, được xây dựng để kỷ niệm sự kiện nào?",
                "Kim tự tháp Giza nằm ở quốc gia nào?",
                "Thành phố nào được mệnh danh là 'Thành phố vĩnh cửu' với những công trình kiến trúc La Mã cổ đại?",
                "Đấu trường Colosseum, một trong những di tích lịch sử nổi tiếng, thuộc quốc gia nào?",
                "Công trình Machu Picchu nằm trên dãy núi nào?",
                "Đảo Bali, một điểm đến du lịch nổi tiếng, thuộc quốc gia nào?",
                "Thác Niagara nằm giữa hai quốc gia nào?",
                "Tượng Nữ thần Tự do (Statue of Liberty), biểu tượng của nước Mỹ, nằm ở thành phố nào?",
                "Công viên quốc gia Yellowstone, một trong những công viên quốc gia lớn nhất thế giới, nằm ở quốc gia nào?",
                "Cung điện Buckingham, nơi ở chính thức của Nữ hoàng Anh, nằm ở thành phố nào?",

                //5
                "Tác giả nào được biết đến với câu thơ 'Quê hương là chùm khế ngọt...?'",
                "Loại động vật nào dưới đây là động vật có vú?",
                "Đỉnh núi Everest nằm trên dãy núi nào?",
                "Cuộc Cách mạng tháng Tám năm 1945 đã chấm dứt chế độ nào ở Việt Nam?",
                "Hội nghị Diên Hồng do triều đại nào triệu tập để bàn cách đánh giặc Nguyên - Mông?",
                "Tác phẩm 'Vợ chồng A Phủ' của Tô Hoài miêu tả cuộc sống của dân tộc nào?",
                "Động vật nào sau đây được coi là loài thông minh nhất?",
                "Vị vua nào của triều đại nhà Nguyễn đã ban hành Chiếu Cần Vương, kêu gọi kháng chiến chống thực dân Pháp?",
                "'Nếu bạn muốn đi nhanh, hãy đi một mình. Nếu bạn muốn đi xa, hãy đi cùng nhau' là câu tục ngữ của quốc gia nào?",
                "Tôi có thể bay mà không có cánh. Tôi có thể khóc nhưng không có mắt. Tôi là gì?",

                //6
                "Thủ đô của quốc gia nào được mệnh danh là 'Thành phố của tình yêu'?",
                "Tác giả của vở kịch nổi tiếng Romeo và Juliet là người của đất nước nào?",
                "Khi xoay hình vuông một góc 45 độ và cắt đôi theo chiều thẳng đứng thì sẽ tạo thành hình gì mới?",
                "Văn học được xếp vào môn nghệ thuật thứ bao nhiêu trong nghệ thuật?",
                "Trên cánh đồng có hai con trâu trắng gặm cỏ, hai con dê uống nước và 5 con gà bới giun. Hỏi trên cánh đồng có tổng bao nhiêu chân?",
                "Tác phẩm nào của nhà thơ Xuân Diệu được coi là biểu tượng của phong trào Thơ mới và nổi bật với chủ đề tình yêu và cuộc sống?",
                "Ai là người đầu tiên đặt chân lên Mặt Trăng vào năm 1969?",
                "Quốc gia nào nằm ở cực Nam của Trái Đất và có một thành phố lớn mang tên 'Cape Town'?",
                "Nhà phát minh nào nổi tiếng với việc phát minh ra bóng đèn điện?",
                "Tên của khu vực nào nằm ở cực Bắc của Trái Đất và được bao phủ bởi băng?"

        };

        String[][] mediumAnswers = {
                //1
                {"Quang Dũng", "Huy Cận", "Tố Hữu", "Xuân Diệu"},
                {"Huấn Cao và viên quản ngục", "Chí Phèo và Thị Nở", "Lão Hạc và cậu Vàng", "Từ Hải và Thúy Kiều"},
                {"Bị quan huyện ép buộc", "Không có tiền nộp thuế", "Nhà cửa bị tịch thu", "Chồng bị bắt giam"},
                {"Một người lái đò dũng cảm", "Một vị tướng trong kháng chiến", "Một nhà văn", "Một nhà giáo"},
                {"Triều Đinh", "Triều Lê", "Triều Trần", "Triều Nguyễn"},
                {"Nguyễn Trường Tộ", "Nguyễn Thiện Thuật", "Phan Đình Phùng", "Trương Định"},
                {"Tách Việt Nam thành hai miền", "Chấm dứt chiến tranh và chia đôi Việt Nam", "Đưa Việt Nam trở thành nước thuộc địa", "Việt Nam được thống nhất ngay lập tức"},
                {"Nhà Đinh", "Nhà Lý", "Nhà Trần", "Nhà Nguyễn"},
                {"Ba Đình", "Tam Kỳ", "Gò Công", "Hương Khê"},
                {"Võ Nguyên Giáp", "Hoàng Văn Thái", "Nguyễn Chí Thanh", "Trần Quang Khải"},

                //2
                {"Chiến dịch Tây Nguyên", "Chiến dịch Huế - Đà Nẵng", "Chiến dịch Quảng Trị", "Chiến dịch Hồ Chí Minh"},
                {"Đinh Bộ Lĩnh", "Lý Thánh Tông", "Trần Nhân Tông", "Lý Thái Tổ"},
                {"Khởi nghĩa Hương Khê", "Khởi nghĩa Ba Đình", "Khởi nghĩa Bãi Sậy", "Khởi nghĩa Yên Thế"},
                {"Lê Lợi", "Lý Thái Tổ", "Trần Hưng Đạo", "Nguyễn Huệ"},
                {"Argentina", "Úc", "Ấn Độ", "Trung Quốc"},
                {"Sydney", "Auckland", "Wellington", "Melbourne"},
                {"Việt Nam", "Thái Lan", "Ấn Độ", "Nhật Bản"},
                {"Sông Yangtze", "Sông Amazon", "Sông Mississippi", "Sông Nile"},
                {"Biển Đỏ", "Biển Đen", "Biển Chết", "Biển Caspian"},
                {"Quảng Ninh", "Ninh Bình", "Hải Phòng", "Thanh Hóa"},

                //3
                {"Nghệ An", "Hà Tĩnh", "Quảng Bình", "Quảng Trị"},
                {"Trường Sơn", "Hoàng Liên Sơn", "Bạch Mã", "Annamite"},
                {"1991", "1993", "1995", "1997"},
                {"Thái Lan", "Lào", "Campuchia", "Trung Quốc"},
                {"Vua Lý Thái Tổ", "Vua Lý Nhân Tông", "Vua Lý Thái Tông", "Vua Trần Nhân Tông"},
                {"Ca trù", "Hát then", "Múa rối nước", "Đèn lồng"},
                {"Bắc Bộ và Nam Bộ", "Trung Bộ và Nam Bộ", "Bắc Trung Bộ và Nam Trung Bộ", "Bắc Bộ và Trung Bộ"},
                {"Quảng Ninh", "Ninh Bình", "Hà Tĩnh", "Thanh Hóa"},
                {"Bà Nà Hills", "Ngũ Hành Sơn", "Sơn Trà", "Hội An"},
                {"Đồng Nai", "Lâm Đồng", "Bình Phước", "Cả ba tỉnh trên"},

                //4
                {"Cuộc Cách mạng Pháp", "Triển lãm Thế giới năm 1889", "Ngày Quốc khánh Pháp", "Khai mạc Thế vận hội"},
                {"Hy Lạp", "Mexico", "Ai Cập", "Peru"},
                {"Paris", "Athens", "Rome", "Cairo"},
                {"Ý", "Tây Ban Nha", "Pháp", "Hy Lạp"},
                {"Rocky", "Alps", "Himalaya", "Andes"},
                {"Malaysia", "Indonesia", "Thái Lan", "Philippines"},
                {"Mexico và Brazil", "Hoa Kỳ và Mexico", "Canada và Nga", "Canada và Hoa Kỳ"},
                {"Washington D.C.", "Chicago", "Los Angeles", "New York"},
                {"Hoa Kỳ", "Canada", "Brazil", "Argentina"},
                {"Edinburgh", "Manchester", "London", "Liverpool"},

                //5
                {"Đỗ Trung Quân", "Hữu Thỉnh", "Nguyễn Duy", "Xuân Diệu"},
                {"Cá mập", "Cá voi", "Cá sấu", "Cá ngựa"},
                {"Andes", "Alps", "Himalaya", "Ural"},
                {"Phong kiến", "Phong kiến và thực dân", "Thực dân Pháp", "Quân đội Nhật"},
                {"Nhà Đinh", "Nhà Lý", "Nhà Trần", "Nhà Lê"},
                {"Dân tộc Dao", "Dân tộc Mông", "Dân tộc Thái", "Dân tộc Tày"},
                {"Chó", "Cá heo", "Đại bàng", "Ngựa"},
                {"Vua Gia Long", "Vua Minh Mạng", "Vua Hàm Nghi", "Vua Bảo Đại"},
                {"Trung Quốc", "Châu phi", "Nhật Bản", "Hoa Kỳ"},
                {"Gió", "Khói", "Nước", "Đám mây"},

                //6
                {"Rome", "Paris", "Venice", "Vienna"},
                {"Hoa Kỳ", "Canada", "Anh", "Pháp"},
                {"Hình tam giác cân", "Hình thang", "Hình vuông", "Hình tứ giác"},
                {"Thứ 4", "Thứ 5", "Thứ nhất", "Thứ 3"},
                {"28 cái", "24 cái", "22 cái", "26 cái"},
                {"Hơi ấm", "Vội Vàng", "Đất Nước", "Tây Tiến"},
                {"Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "John Glenn"},
                {"Argentina", "Chile", "Nam Phi", "New Zealand"},
                {"Nikola Tesla", "Alexander Graham Bell", "James Watt", "Thomas Edison"},
                {"Nam Cực (Antarctica)", "Bắc Cực (Arctic)", "Thái Bình Dương", "Amazon"}
        };

        int[] mediumCorrectAnswers = {1,1,2,1,2,3,2,3,3,1,  3,3,2,2,1,3,3,4,3,1,  2,1,1,3,1,4,3,2,1,1,  2,2,3,1,4,2,4,4,1,3,  1,2,3,2,3,2,2,3,1,4,  2,3,1,4,4,2,1,3,4,2};
        addQuestionsToDatabase(db, mediumQuestions, mediumAnswers, mediumCorrectAnswers, 2);
    }

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ khó
    public static void addHardQuestions(SQLiteDatabase db) {
        String[] hardQuestions = {
                //1
                "Lực lượng đặc biệt của Đức quốc xã gọi là gì?",
                "Nhà khoa học nào khám phá ra penicillin?",
                "Đại dương nào lớn nhất trên Trái đất?",
                "Công nghệ nào được sử dụng để cải thiện hiệu suất mạng bằng cách giảm thiểu độ trễ và tăng cường khả năng truyền tải dữ liệu?",
                "Đâu là thuật toán được sử dụng để mã hóa dữ liệu và bảo mật thông tin trong giao dịch trực tuyến?",
                "Trong lĩnh vực trí tuệ nhân tạo, khái niệm nào mô tả khả năng của một hệ thống để học từ dữ liệu và cải thiện hiệu suất theo thời gian?",
                "Trong hệ thống quản lý cơ sở dữ liệu, khái niệm nào mô tả mối quan hệ giữa các bảng dữ liệu và đảm bảo tính toàn vẹn của dữ liệu?",
                "Công nghệ nào được sử dụng để tạo ra các mô hình ba chiều trong thiết kế và sản xuất?",
                "Công nghệ blockchain được ứng dụng chủ yếu trong lĩnh vực nào?",
                "Đâu là công nghệ chính được sử dụng để phát triển các ứng dụng di động trên nền tảng iOS?",

                //2
                "Trong phát triển phần mềm, khái niệm nào mô tả quy trình kiểm tra và đánh giá phần mềm để tìm lỗi và khuyết điểm?",
                "Trong thiết kế hệ thống mạng, thuật ngữ nào mô tả cách mà các thiết bị kết nối và giao tiếp với nhau qua mạng?",
                "Công nghệ nào cho phép giao tiếp giữa các thiết bị và cảm biến qua mạng mà không cần sự can thiệp của con người?",
                "Tác phẩm nào của James Joyce nổi tiếng vì kỹ thuật dòng ý thức và phân tích sâu sắc tâm lý nhân vật?",
                "Trong tác phẩm 'Tấm Cám', ai là nhân vật chính có thể hiện rõ nhất đặc điểm của người thừa kế đích thực?",
                "Tác phẩm nào của Hermann Hesse khám phá cuộc tìm kiếm bản sắc cá nhân và sự tự tìm hiểu?",
                "Ai là tác giả của tác phẩm 'Moby-Dick'?",
                "Trong tác phẩm 'Chế độ phong kiến và tư bản', tác giả nào đã phân tích sự chuyển mình từ chế độ phong kiến sang chế độ tư bản?",
                "Tác phẩm nào của William Faulkner sử dụng cấu trúc kể chuyện phi tuyến tính và phân tích sâu sắc về sự rối loạn tâm lý?",
                "Tác giả nào đã viết cuốn sách 'Những suy nghĩ về văn hóa và xã hội'?",

                //3
                "Trong tác phẩm 'Cảnh sát và quân đội', tác giả nào đã phân tích mối quan hệ giữa quyền lực và xã hội?",
                "Ai là tác giả của cuốn sách 'Cuộc sống và các giai đoạn của nó'?",
                "Tác phẩm nào của Virginia Woolf được viết dưới dạng độc thoại nội tâm và khám phá chủ đề thời gian và tâm lý nhân vật?",
                "Ai là nhà lãnh đạo của cuộc Kháng chiến chống Pháp và sau đó trở thành tổng thống của nước Việt Nam Dân chủ Cộng hòa?",
                "Sự kiện nào được coi là kết thúc thời kỳ đen tối của nền văn minh châu Âu?",
                "Trong lịch sử Trung Quốc, ai là người sáng lập triều đại Minh và khôi phục sự ổn định sau triều đại Nguyên?",
                "Ai là nhà lãnh đạo của phong trào cách mạng Bolshevik ở Nga vào năm 1917?",
                "Sự kiện nào được coi là bắt đầu cuộc chiến tranh lạnh giữa Mỹ và Liên Xô?",
                "Trong lịch sử đế quốc Ottoman, ai là sultan nổi tiếng vì đã chinh phục Constantinople?",
                "Ai là nhân vật chính trong cuộc chiến tranh giành độc lập của Mỹ và sau đó trở thành tổng thống đầu tiên của Hoa Kỳ?",

                //4
                "Trong thời kỳ cận đại, ai là nhân vật chính trong cuộc cải cách xã hội và kinh tế ở Nhật Bản, được gọi là Minh Trị?",
                "Ai là nhân vật chính trong cuộc chiến tranh Napoleon và sau đó trở thành hoàng đế của Pháp?",
                "Sự kiện nào đánh dấu sự kết thúc của chế độ phong kiến ở Pháp?",
                "Dãy núi nào là phân cách chính giữa châu Âu và châu Á?",
                "Đâu là quốc gia duy nhất có thể đứng trên ba châu lục (Á, Âu, Phi) và có điểm cao nhất ở châu Phi?"
        };

        String[][] hardAnswers = {
                //1
                {"SS", "Gestapo", "Wehrmacht", "Luftwaffe"},
                {"Marie Curie", "Alexander Fleming", "Albert Einstein", "Isaac Newton"},
                {"Thái Bình Dương", "Đại Tây Dương", "Ấn Độ Dương", "Bắc Băng Dương"},
                {"Mạng lưới dây dẫn quang", "Mạng lưới băng thông rộng", "Công nghệ 5G", "Hệ thống mạng không dây"},
                {"Thuật toán RSA", "Thuật toán AES", "Thuật toán SHA-256", "Thuật toán MD5"},
                {"Deep Learning", "Neural Networks", "Machine Learning", "Natural Language Processing"},
                {"Khóa chính", "Khóa độc nhất", "Khóa phụ", "Khóa ngoại"},
                {"GIS (Geographic Information System)", "CAM (Computer-Aided Manufacturing)", "CAD (Computer-Aided Design)", "VR (Virtual Reality)"},
                {"Mạng xã hội", "Tài chính và tiền điện tử", "Giải trí và game", "Hệ thống quản lý nội dung"},
                {"Swift", "Kotlin", "Java", "C#"},

                //2
                {"Phát triển ứng dụng", "Phân tích hệ thống", "Thiết kế phần mềm", "Kiểm thử phần mềm"},
                {"Kiến trúc mạng", "Địa chỉ IP", "Giao thức mạng", "Băng thông"},
                {"Internet of Things (IoT)", "Big Data", "Cloud Computing", "Virtual Reality"},
                {"Dubliners", "A Portrait of the Artist as a Young Man", "Ulysses", "Finnegans Wake"},
                {"Cám", "Tấm", "Hoàng tử", "Bà mẹ kế"},
                {"Steppenwolf", "Siddhartha", "The Glass Bead Game", "Demian"},
                {"Walt Whitman", "Nathaniel Hawthorne", "Edgar Allan Poe", "Herman Melville"},
                {"Friedrich Engels", "Max Weber", "Karl Marx", "Adam Smith"},
                {"The Sound and the Fury", "As I Lay Dying", "Light in August", "Absalom, Absalom!"},
                {"Michel Foucault", "Pierre Bourdieu", "Jürgen Habermas", "Erving Goffman"},

                //3
                {"Max Weber", "Karl Marx", "Michel Foucault", "John Rawls"},
                {"Jean Piaget", "Erik Erikson", "Lev Vygotsky", "Sigmund Freud"},
                {"Mrs. Dalloway", "To the Lighthouse", "Orlando", "The Waves"},
                {"Hồ Chí Minh", "Võ Nguyên Giáp", "Phan Bội Châu", "Nguyễn Ái Quốc"},
                {"Sự sụp đổ của Đế chế La Mã", "Cuộc đại cách mạng Pháp", "Sự phát triển của Phục hưng", "Khám phá của Christopher Columbus"},
                {"Lý Tự Thành", "Vương Mã", "Tôn Trung Sơn", "Chu Nguyên Chương"},
                {"Alexander Kerensky", "Joseph Stalin", "Leon Trotsky", "Vladimir Lenin"},
                {"Cuộc khủng hoảng tên lửa Cuba", "Hội nghị Yalta", "Cuộc tấn công của Nhật Bản vào Pearl Harbor", "Sự thành lập NATO"},
                {"Suleiman the Magnificent", "Mehmed II", "Selim I", "Osman I"},
                {"Benjamin Franklin", "Thomas Jefferson", "George Washington", "John Adams"},

                //4
                {"Minh Trị Thiên Hoàng", "Tokugawa Ieyasu", "Oda Nobunaga", "Toyotomi Hideyoshi"},
                {"Charles de Gaulle", "Louis XVI", "Napoleon Bonaparte", "Louis Napoleon"},
                {"Cải cách tôn giáo", "Cuộc chiến tranh một trăm năm", "Cuộc cách mạng Pháp năm 1789", "Sự sụp đổ của Đế chế La Mã"},
                {"Dãy Ural", "Dãy Himalaya", "Dãy Andes", "Dãy Rocky"},
                {"Thổ Nhĩ Kỳ", "Ai Cập", "Hy Lạp", "Iran"}
        };

        int[] hardCorrectAnswers = {1,2,1,3,1,3,4,3,2,1,  4,1,1,3,2,2,4,3,1,2,  3,2,2,1,3,4,4,2,2,3,  1,3,3,1,1};
        addQuestionsToDatabase(db, hardQuestions, hardAnswers, hardCorrectAnswers, 3);
    }


    // Phương thức để thêm câu hỏi vào cơ sở dữ liệu
    private static void addQuestionsToDatabase(SQLiteDatabase db, String[] questions, String[][] answers, int[] correctAnswers, int level) {
        for (int i = 0; i < questions.length; i++) {
            ContentValues cv = new ContentValues();
            cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions[i]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION1, answers[i][0]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION2, answers[i][1]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION3, answers[i][2]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION4, answers[i][3]);
            cv.put(QuizContract.QuestionTable.COLUMN_ANSWER_NR, correctAnswers[i]);
            cv.put(QuizContract.QuestionTable.COLUMN_LEVEL, level);
            db.insert(QuizContract.QuestionTable.TABLE_NAME, null, cv);
        }
    }
}
