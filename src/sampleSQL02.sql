USE sampleDB02

CREATE TABLE 出荷先 (
    出荷先ID INT IDENTITY(1, 1) CONSTRAINT PK_出荷先ID PRIMARY KEY (出荷先ID),
    出荷先名 NVARCHAR(50) NOT NULL,
    出荷先都道府県 NVARCHAR(10) NOT NULL,
    出荷先住所 NVARCHAR(50) NOT NULL
)

CREATE TABLE 受注 (
    受注ID INT IDENTITY(1001, 1) CONSTRAINT PK_受注ID PRIMARY KEY (受注ID),
    出荷先ID INT NOT NULL CONSTRAINT FK_出荷先ID FOREIGN KEY (出荷先ID) REFERENCES 出荷先(出荷先ID),
    受注日 DATE NOT NULL
)

CREATE TABLE 商品 (
    商品ID INT IDENTITY(1, 1) CONSTRAINT PK_商品ID PRIMARY KEY (商品ID),
    商品名 NVARCHAR(30) NOT NULL,
    区分 NVARCHAR(10)
)

CREATE TABLE 受注明細 (
    受注ID INT NOT NULL CONSTRAINT FK_受注ID FOREIGN KEY (受注ID) REFERENCES 受注(受注ID),
    商品ID INT NOT NULL CONSTRAINT FK_商品ID FOREIGN KEY (商品ID) REFERENCES 商品(商品ID),
    単価 MONEY NOT NULL,
    数量 INT NOT NULL
)
   
--データをinsert後

SELECT 受注明細.受注ID, 商品名, 単価, 数量, 単価 * 数量 AS 価格計, 出荷先名 FROM 受注明細 LEFT JOIN 商品
    ON 受注明細.商品ID = 商品.商品ID LEFT JOIN 受注
    ON 受注明細.受注ID = 受注.受注ID LEFT JOIN 出荷先
    ON 受注.出荷先ID = 出荷先.出荷先ID WHERE 受注.受注ID BETWEEN 1001 AND 1005

SELECT SUM(単価 * 数量) AS 受注金額の総合計 FROM 受注明細

SELECT 商品.商品ID, 商品名, 区分, 単価, 単価 * 0.7 AS '3割引' FROM 商品 LEFT JOIN 受注明細
    ON 受注明細.商品ID = 商品.商品ID WHERE 単価 * 0.7 >= 500

SELECT 商品.商品ID, 商品名, SUM(単価 * 数量) AS 受注金額合計 FROM 受注明細
    LEFT JOIN 商品 ON 受注明細.商品ID = 商品.商品ID
    GROUP BY 商品.商品ID, 商品名 ORDER BY SUM(単価 * 数量) DESC

SELECT 出荷先名, COUNT(*) AS 受注回数 FROM 受注
    LEFT JOIN 出荷先 ON 受注.出荷先ID = 出荷先.出荷先ID
    GROUP BY 出荷先名

SELECT * FROM 商品 LEFT JOIN 受注明細
    ON 商品.商品ID = 受注明細.商品ID WHERE 商品名 LIKE (N'%冷凍%')