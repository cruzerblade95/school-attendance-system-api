-- Student

insert into `student` (id, name, username, password, collage, major, creation_date)
values (1, "Student 1", "student", "$2a$10$OMYOpI4D8.UgDQ7t9kcHhuPkmkWOFdL.78pbN2Kdnhp8KJD8j4skG",
        "College of Science", "Maths", "2021-01-06T01:10:17.852");


-- Teacher
insert into `teacher` (id, name, username, password, phone, email, office_location, office_hours_from, office_hours_to,
                       office_hours_days)
values (1, "Teacher 1", "teacher", "teacher", "0791234567", "teacher1@google.com", "GF", "10:00", "12:00",
        "Sunday - Tuesday - Thursday");


-- Course
insert into `course` (id, name, hour_from, hour_to, days, hours, section_number)
values (1, "Introduction to programming", "08:00", "09:00", "إثنين - اربعاء", 3, 1);


-- Teacher-Course
insert into `teacher_course` (id, course_id, teacher_id)
values (1, 1, 1);


-- Student-Course
insert into `student_course` (id, student_id, course_id)
values (1, 1, 1);


-- Article
-- insert into `article` (id, content, title, image_url)
-- values (1, "البلقاء تتأهل الى المسابقة العربية", "بفضل فريق One&HalfThreads", "https://i.ibb.co/sWRyJHp/article.png");
-- insert into `article` (id, content, title, image_url)
-- values (2, "الزعبي يكرم الطلبة الفائزين بالمسابقة البيئية في البلقاء", "تكريم الفائزين بالمسابقة ",
--         "https://www.bau.edu.jo/BauLivePortal/attch/9107_7.jpg");
-- insert into `article` (id, content, title, image_url)
-- values (3, "رئيس جامعة البلقاء التطبيقية يلتقي أسرة كلية الأميرة رحمة الجامعية", "الزعبي في كلية الأميرة رحمة ",
--         "https://live.bau.edu.jo/BauLivePortal/attch/9101_5.jpg");
-- insert into `article` (id, content, title, image_url)
-- values (4, "رئيس جامعة البلقاء التطبيقية يهنئ أسرة كلية عمان الجامعية بحصولها على شهادة ضمان الجودة",
--         "كلية عمان داخل نظام الجودة", "https://live.bau.edu.jo/BauLivePortal/attch/9108_4.jpg");
-- insert into `article` (id, content, title, image_url)
-- values (5, "اعلان نتائج المنح والقروض للاطلاع يرجى", "اعلان نتائج المنح والقروض",
--         "https://i.ibb.co/sWRyJHp/article.png");
-- insert into `article` (id, content, title, image_url)
-- values (6, "اختتام دورة مهارات التفكير والتخطيط الاستراتيجي في كلية الاميره عالية الجامعية بالتعاون مع المركز الوطني ",
--         "اختتام دورة مهارات التفكير", "https://live.bau.edu.jo/BauLivePortal/attch/9109_3.jpg");
-- insert into `article` (id, content, title, image_url)
-- values (7, "اعلان تعديل مواعيد الانسحاب من مادة أو أكثر الفصل الدراسي الاول", "اعلان تعديل مواعيد",
--         "https://i.ibb.co/sWRyJHp/article.png");
-- insert into `article` (id, content, title, image_url)
-- values (8, "مناقشة رسالة ماجستير في كلية اربد الجامعية", "مناقشة", "https://i.ibb.co/sWRyJHp/article.png");
-- insert into `article` (id, content, title, image_url)
-- values (9, "البلقاء التطبيقية تشارك في ورشة إقليمية حول مفهوم التعليم العالي التطبيقي وتحسين جودته",
--         "البلقاء التطبيقية تشارك في ورشة إقليمية", "https://i.ibb.co/sWRyJHp/article.png");
-- insert into `article` (id, content, title, image_url)
-- values (10, "الزراعة التكنولوجية وشؤون الطلبة تنظمان نشاطا زراعيا للطلبة في البلقاء التطبيقية", "الزراعة التكنولوجية",
--         "https://live.bau.edu.jo/BauLivePortal/attch/9110_4.jpg");
