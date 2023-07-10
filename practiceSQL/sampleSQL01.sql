use sampleDB01
CREATE TABLE 部門(
    部門ID int IDENTITY(1, 1) CONSTRAINT PK_所属 PRIMARY KEY (部門ID),
    部門 nvarchar(30) NOT NULL
)
INSERT INTO 部門(部門) VALUES (N'営業')
INSERT INTO 部門 VALUES (N'エンジニア')

SELECT * FROM 部門

CREATE TABLE 社員(
    ID int IDENTITY(1, 1) CONSTRAINT PK_社員 PRIMARY KEY (ID),
    姓 nvarchar(30) NOT NULL,
    名 nvarchar(30) NOT NULL,
    部門ID int NOT NULL CONSTRAINT FK_部門ID FOREIGN KEY (部門ID) REFERENCES 部門(部門ID)
)
INSERT INTO 社員 VALUES (N'田中', N'正俊', 3)

SELECT * FROM 社員
