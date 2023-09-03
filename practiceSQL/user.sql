use [user];
CREATE TABLE ユーザー (
    userId int IDENTITY(1000, 1) CONSTRAINT pk_userId PRIMARY KEY,
    userName nvarchar(30) NOT NULL,
    password nvarchar(30) NOT NULL,
)

INSERT INTO ユーザー VALUES ('saitou', '1111');