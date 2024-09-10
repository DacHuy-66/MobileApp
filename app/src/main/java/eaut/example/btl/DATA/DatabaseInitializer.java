package eaut.example.btl.DATA;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseInitializer {

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ dễ
    public static void addEasyQuestions(SQLiteDatabase db) {
        String[] easyQuestions = {
                "Đâu là thủ đô của Việt Nam?",
                "Sông nào dài nhất thế giới?",
                "Ai là tác giả của truyện ngắn 'Lão Hạc'?",
                // Thêm 7 câu hỏi dễ khác
        };

        String[][] easyAnswers = {
                {"Hà Nội", "Sài Gòn", "Đà Nẵng", "Huế"},
                {"Sông Nile", "Sông Amazon", "Sông Hằng", "Sông Mekong"},
                {"Nam Cao", "Nguyễn Du", "Ngô Tất Tố", "Tố Hữu"},
                // Thêm đáp án cho các câu hỏi dễ khác
        };

        int[] easyCorrectAnswers = {1, 1, 1}; // Đáp án đúng tương ứng
        addQuestionsToDatabase(db, easyQuestions, easyAnswers, easyCorrectAnswers, 1);
    }

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ vừa
    public static void addMediumQuestions(SQLiteDatabase db) {
        String[] mediumQuestions = {
                "Hành tinh nào gần mặt trời nhất?",
                "Trong bảng tuần hoàn, ký hiệu hóa học của vàng là gì?",
                "Vị vua nào là người sáng lập triều đại nhà Nguyễn?",
                // Thêm 7 câu hỏi vừa khác
        };

        String[][] mediumAnswers = {
                {"Sao Kim", "Sao Thủy", "Sao Hỏa", "Sao Mộc"},
                {"Au", "Ag", "Pt", "Pb"},
                {"Gia Long", "Minh Mạng", "Tự Đức", "Bảo Đại"},
                // Thêm đáp án cho các câu hỏi vừa khác
        };

        int[] mediumCorrectAnswers = {2, 1, 1}; // Đáp án đúng tương ứng
        addQuestionsToDatabase(db, mediumQuestions, mediumAnswers, mediumCorrectAnswers, 2);
    }

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ khó
    public static void addHardQuestions(SQLiteDatabase db) {
        String[] hardQuestions = {
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
                "Trong thời kỳ cận đại, ai là nhân vật chính trong cuộc cải cách xã hội và kinh tế ở Nhật Bản, được gọi là Minh Trị?",
                "Ai là nhân vật chính trong cuộc chiến tranh Napoleon và sau đó trở thành hoàng đế của Pháp?",
                "Sự kiện nào đánh dấu sự kết thúc của chế độ phong kiến ở Pháp?",
                "Dãy núi nào là phân cách chính giữa châu Âu và châu Á?",
                "Đâu là quốc gia duy nhất có thể đứng trên ba châu lục (Á, Âu, Phi) và có điểm cao nhất ở châu Phi?"
        };

        String[][] hardAnswers = {
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
                {"Minh Trị Thiên Hoàng", "Tokugawa Ieyasu", "Oda Nobunaga", "Toyotomi Hideyoshi"},
                {"Charles de Gaulle", "Louis XVI", "Napoleon Bonaparte", "Louis Napoleon"},
                {"Cải cách tôn giáo", "Cuộc chiến tranh một trăm năm", "Cuộc cách mạng Pháp năm 1789", "Sự sụp đổ của Đế chế La Mã"},
                {"Dãy Ural", "Dãy Himalaya", "Dãy Andes", "Dãy Rocky"},
                {"Thổ Nhĩ Kỳ", "Ai Cập", "Hy Lạp", "Iran"}
        };

        int[] hardCorrectAnswers = {1, 2, 1,  3,1,3,4,3,2,1,4,1,  1,3,2,2,4,3,1,2,3,2,  2,1,3,  4,4,2,2,3,1,3,3,1,1};
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
