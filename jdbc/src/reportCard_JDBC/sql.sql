USE ReportCard

CREATE TABLE grade (
    id int IDENTITY(100, 1) CONSTRAINT pk_id PRIMARY KEY,
    team nvarchar(10) NOT NULL,
    name nvarchar(50) NOT NULL,
    englishScore int NOT NULL,
    mathScore int NOT NULL
)

INSERT INTO grade(team, name, englishScore, mathScore) VALUES
    ('1',N'緑川',52,50),
    ('1',N'黒田',23,30),
    ('1',N'赤井',67,60),
    ('1',N'青木',70,90),
    ('1',N'水谷',72,94),
    ('1',N'茶谷',90,84),
    ('1',N'桜庭',35,42),
    ('2',N'落合',55,60),
    ('2',N'長嶋',33,3),
    ('2',N'清原',40,55),
    ('2',N'川相',70,85),
    ('2',N'桑田',86,92),
    ('2',N'秋山',60,65),
    ('2',N'鈴木',60,70),
    ('3',N'本田',90,35),
    ('3',N'松下',85,72),
    ('3',N'岩崎',85,90),
    ('3',N'盛田',80,90),
    ('3',N'高田',95,45)
