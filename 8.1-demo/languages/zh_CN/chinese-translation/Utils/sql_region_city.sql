DO $$DECLARE 
/* 
 * 基于中国人民共和国国家统计局2017-3-1发布的截止于2016-7-31的最新县及县以上行政区划代码
 * http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201703/t20170310_1471429.html
 * 
 * 执行前提：数据库初始化后既可以执行，如果已经有维护中国的省市信息的话，需要完全删除（含引用的业务数据）后方可执行
 * 执行结果：
 *   select count(*) from c_region WHERE c_country_id = 153; 
 *    = 34
 *   select count(*) from c_city WHERE c_country_id = 153; 
 *    = 422
 *
*/
BEGIN
	-- 国家/地区"中国"的国家包含区域字段改为Y
	UPDATE c_country SET hasregion = 'Y' WHERE c_country_id = 153;

	-- 导入"中国"的区域名称和城市的初始数据
	DELETE FROM c_city WHERE c_country_id = 153;
	DELETE FROM c_region WHERE c_country_id = 153;

	--------------------------------------------------
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','北京市','[110000]北京市[BEI JING SHI]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','天津市','[120000]天津市[TIAN JIN SHI]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','河北省','[130000]河北省[HE BEI SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','山西省','[140000]山西省[SHAN XI SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','内蒙古自治区','[150000]内蒙古自治区[NEI MENG GU ZI ZHI QU]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','辽宁省','[210000]辽宁省[LIAO NING SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','吉林省','[220000]吉林省[JI LIN SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黑龙江省','[230000]黑龙江省[HEI LONG JIANG SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','上海市','[310000]上海市[SHANG HAI SHI]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','江苏省','[320000]江苏省[JIANG SU SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','浙江省','[330000]浙江省[ZHE JIANG SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','安徽省','[340000]安徽省[AN HUI SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','福建省','[350000]福建省[FU JIAN SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','江西省','[360000]江西省[JIANG XI SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','山东省','[370000]山东省[SHAN DONG SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','河南省','[410000]河南省[HE NAN SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','湖北省','[420000]湖北省[HU BEI SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','湖南省','[430000]湖南省[HU NAN SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','广东省','[440000]广东省[GUANG DONG SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','广西壮族自治区','[450000]广西壮族自治区[GUANG XI ZHUANG ZU ZI ZHI QU]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','海南省','[460000]海南省[HAI NAN SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','重庆市','[500000]重庆市[ZHONG QING SHI]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','四川省','[510000]四川省[SI CHUAN SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','贵州省','[520000]贵州省[GUI ZHOU SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','云南省','[530000]云南省[YUN NAN SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','西藏自治区','[540000]西藏自治区[XI CANG ZI ZHI QU]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','陕西省','[610000]陕西省[SHAN XI SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','甘肃省','[620000]甘肃省[GAN SU SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','青海省','[630000]青海省[QING HAI SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宁夏回族自治区','[640000]宁夏回族自治区[NING XIA HUI ZU ZI ZHI QU]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','新疆维吾尔自治区','[650000]新疆维吾尔自治区[XIN JIANG WEI WU ER ZI ZHI QU]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','台湾省','[710000]台湾省[TAI WAN SHENG]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','香港特别行政区','[810000]香港特别行政区[XIANG GANG TE BIE XING ZHENG QU]','153','N',generate_uuid());
	INSERT INTO c_region (c_region_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,description,c_country_id,isdefault,c_region_uu) 
		VALUES (nextid(62,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','澳门特别行政区','[820000]澳门特别行政区[AO MEN TE BIE XING ZHENG QU]','153','N',generate_uuid());

	--------------------------------------------------
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','东城区','110101','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','西城区','110102','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','朝阳区','110105','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','丰台区','110106','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','石景山区','110107','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','海淀区','110108','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','门头沟区','110109','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','房山区','110111','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','通州区','110112','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','顺义区','110113','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','昌平区','110114','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','大兴区','110115','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','怀柔区','110116','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','平谷区','110117','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','密云区','110118','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','延庆区','110119','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '11'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','和平区','120101','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','河东区','120102','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','河西区','120103','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南开区','120104','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','河北区','120105','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','红桥区','120106','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','东丽区','120110','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','西青区','120111','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','津南区','120112','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','北辰区','120113','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','武清区','120114','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宝坻区','120115','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','滨海新区','120116','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宁河区','120117','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','静海区','120118','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','蓟州区','120119','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '12'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','石家庄市','130100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','唐山市','130200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','秦皇岛市','130300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','邯郸市','130400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','邢台市','130500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','保定市','130600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','张家口市','130700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','承德市','130800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','沧州市','130900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','廊坊市','131000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','衡水市','131100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','定州市','139001','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','辛集市','139002','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '13'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','太原市','140100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','大同市','140200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阳泉市','140300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','长治市','140400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','晋城市','140500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','朔州市','140600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','晋中市','140700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','运城市','140800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','忻州市','140900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','临汾市','141000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','吕梁市','141100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '14'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','呼和浩特市','150100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','包头市','150200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','乌海市','150300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','赤峰市','150400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','通辽市','150500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','鄂尔多斯市','150600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','呼伦贝尔市','150700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','巴彦淖尔市','150800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','乌兰察布市','150900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','兴安盟','152200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','锡林郭勒盟','152500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阿拉善盟','152900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '15'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','沈阳市','210100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','大连市','210200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','鞍山市','210300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','抚顺市','210400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','本溪市','210500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','丹东市','210600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','锦州市','210700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','营口市','210800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阜新市','210900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','辽阳市','211000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','盘锦市','211100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','铁岭市','211200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','朝阳市','211300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','葫芦岛市','211400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '21'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','长春市','220100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','吉林市','220200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','四平市','220300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','辽源市','220400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','通化市','220500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','白山市','220600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','松原市','220700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','白城市','220800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','延边朝鲜族自治州','222400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '22'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','哈尔滨市','230100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','齐齐哈尔市','230200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','鸡西市','230300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','鹤岗市','230400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','双鸭山市','230500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','大庆市','230600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','伊春市','230700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','佳木斯市','230800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','七台河市','230900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','牡丹江市','231000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黑河市','231100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','绥化市','231200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','大兴安岭地区','232700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '23'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黄浦区','310101','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','徐汇区','310104','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','长宁区','310105','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','静安区','310106','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','普陀区','310107','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','虹口区','310109','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','杨浦区','310110','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','闵行区','310112','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宝山区','310113','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','嘉定区','310114','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','浦东新区','310115','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','金山区','310116','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','松江区','310117','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','青浦区','310118','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','奉贤区','310120','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','崇明区','310151','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '31'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南京市','320100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','无锡市','320200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','徐州市','320300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','常州市','320400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','苏州市','320500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南通市','320600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','连云港市','320700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','淮安市','320800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','盐城市','320900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','扬州市','321000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','镇江市','321100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','泰州市','321200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宿迁市','321300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '32'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','杭州市','330100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宁波市','330200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','温州市','330300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','嘉兴市','330400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','湖州市','330500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','绍兴市','330600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','金华市','330700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','衢州市','330800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','舟山市','330900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','台州市','331000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','丽水市','331100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '33'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','合肥市','340100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','芜湖市','340200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','蚌埠市','340300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','淮南市','340400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','马鞍山市','340500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','淮北市','340600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','铜陵市','340700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','安庆市','340800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黄山市','341000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','滁州市','341100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阜阳市','341200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宿州市','341300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','六安市','341500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','亳州市','341600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','池州市','341700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宣城市','341800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '34'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','福州市','350100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','厦门市','350200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','莆田市','350300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','三明市','350400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','泉州市','350500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','漳州市','350600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南平市','350700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','龙岩市','350800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宁德市','350900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '35'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南昌市','360100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','景德镇市','360200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','萍乡市','360300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','九江市','360400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','新余市','360500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','鹰潭市','360600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','赣州市','360700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','吉安市','360800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宜春市','360900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','抚州市','361000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','上饶市','361100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '36'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','济南市','370100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','青岛市','370200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','淄博市','370300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','枣庄市','370400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','东营市','370500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','烟台市','370600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','潍坊市','370700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','济宁市','370800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','泰安市','370900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','威海市','371000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','日照市','371100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','莱芜市','371200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','临沂市','371300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','德州市','371400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','聊城市','371500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','滨州市','371600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','菏泽市','371700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '37'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','郑州市','410100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','开封市','410200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','洛阳市','410300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','平顶山市','410400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','安阳市','410500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','鹤壁市','410600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','新乡市','410700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','焦作市','410800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','濮阳市','410900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','许昌市','411000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','漯河市','411100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','三门峡市','411200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南阳市','411300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','商丘市','411400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','信阳市','411500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','周口市','411600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','驻马店市','411700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '41'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','武汉市','420100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黄石市','420200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','十堰市','420300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宜昌市','420500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','襄阳市','420600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','鄂州市','420700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','荆门市','420800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','孝感市','420900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','荆州市','421000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黄冈市','421100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','咸宁市','421200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','随州市','421300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','恩施土家族苗族自治州','422800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '42'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','长沙市','430100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','株洲市','430200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','湘潭市','430300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','衡阳市','430400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','邵阳市','430500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','岳阳市','430600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','常德市','430700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','张家界市','430800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','益阳市','430900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','郴州市','431000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','永州市','431100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','怀化市','431200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','娄底市','431300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','湘西土家族苗族自治州','433100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '43'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','广州市','440100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','韶关市','440200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','深圳市','440300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','珠海市','440400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','汕头市','440500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','佛山市','440600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','江门市','440700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','湛江市','440800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','茂名市','440900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','肇庆市','441200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','惠州市','441300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','梅州市','441400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','汕尾市','441500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','河源市','441600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阳江市','441700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','清远市','441800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','东莞市','441900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','中山市','442000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','潮州市','445100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','揭阳市','445200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','云浮市','445300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '44'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南宁市','450100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','柳州市','450200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','桂林市','450300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','梧州市','450400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','北海市','450500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','防城港市','450600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','钦州市','450700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','贵港市','450800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','玉林市','450900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','百色市','451000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','贺州市','451100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','河池市','451200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','来宾市','451300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','崇左市','451400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '45'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','海口市','460100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '46'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','三亚市','460200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '46'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','三沙市','460300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '46'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','儋州市','460400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '46'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','万州区','500101','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','涪陵区','500102','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','渝中区','500103','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','大渡口区','500104','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','江北区','500105','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','沙坪坝区','500106','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','九龙坡区','500107','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南岸区','500108','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','北碚区','500109','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','綦江区','500110','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','大足区','500111','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','渝北区','500112','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','巴南区','500113','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黔江区','500114','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','长寿区','500115','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','江津区','500116','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','合川区','500117','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','永川区','500118','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南川区','500119','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','璧山区','500120','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','铜梁区','500151','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','潼南区','500152','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','荣昌区','500153','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','开州区','500154','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','梁平县','500228','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','城口县','500229','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','丰都县','500230','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','垫江县','500231','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','武隆县','500232','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','忠县','500233','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','云阳县','500235','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','奉节县','500236','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','巫山县','500237','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','巫溪县','500238','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','石柱土家族自治县','500240','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','秀山土家族苗族自治县','500241','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','酉阳土家族苗族自治县','500242','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','彭水苗族土家族自治县','500243','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '50'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','成都市','510100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','自贡市','510300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','攀枝花市','510400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','泸州市','510500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','德阳市','510600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','绵阳市','510700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','广元市','510800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','遂宁市','510900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','内江市','511000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','乐山市','511100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','南充市','511300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','眉山市','511400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宜宾市','511500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','广安市','511600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','达州市','511700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','雅安市','511800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','巴中市','511900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','资阳市','512000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阿坝藏族羌族自治州','513200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','甘孜藏族自治州','513300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','凉山彝族自治州','513400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '51'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','贵阳市','520100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','六盘水市','520200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','遵义市','520300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','安顺市','520400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','毕节市','520500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','铜仁市','520600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黔西南布依族苗族自治州','522300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黔东南苗族侗族自治州','522600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黔南布依族苗族自治州','522700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '52'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','昆明市','530100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','曲靖市','530300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','玉溪市','530400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','保山市','530500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','昭通市','530600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','丽江市','530700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','普洱市','530800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','临沧市','530900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','楚雄彝族自治州','532300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','红河哈尼族彝族自治州','532500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','文山壮族苗族自治州','532600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','西双版纳傣族自治州','532800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','大理白族自治州','532900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','德宏傣族景颇族自治州','533100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','怒江傈僳族自治州','533300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','迪庆藏族自治州','533400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '53'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','拉萨市','540100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '54'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','日喀则市','540200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '54'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','昌都市','540300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '54'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','林芝市','540400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '54'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','山南市','540500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '54'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','那曲地区','542400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '54'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阿里地区','542500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '54'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','西安市','610100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','铜川市','610200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','宝鸡市','610300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','咸阳市','610400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','渭南市','610500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','延安市','610600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','汉中市','610700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','榆林市','610800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','安康市','610900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','商洛市','611000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '61'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','兰州市','620100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','嘉峪关市','620200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','金昌市','620300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','白银市','620400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','天水市','620500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','武威市','620600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','张掖市','620700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','平凉市','620800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','酒泉市','620900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','庆阳市','621000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','定西市','621100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','陇南市','621200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','临夏回族自治州','622900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','甘南藏族自治州','623000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '62'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','西宁市','630100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '63'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','海东市','630200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '63'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','海北藏族自治州','632200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '63'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','黄南藏族自治州','632300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '63'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','海南藏族自治州','632500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '63'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','果洛藏族自治州','632600','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '63'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','玉树藏族自治州','632700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '63'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','海西蒙古族藏族自治州','632800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '63'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','银川市','640100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '64'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','石嘴山市','640200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '64'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','吴忠市','640300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '64'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','固原市','640400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '64'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','中卫市','640500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '64'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','乌鲁木齐市','650100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','克拉玛依市','650200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','吐鲁番市','650400','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','哈密市','650500','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','昌吉回族自治州','652300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','博尔塔拉蒙古自治州','652700','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','巴音郭楞蒙古自治州','652800','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阿克苏地区','652900','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','克孜勒苏柯尔克孜自治州','653000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','喀什地区','653100','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','和田地区','653200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','伊犁哈萨克自治州','654000','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','塔城地区','654200','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
	INSERT INTO C_CITY (c_city_id,ad_client_id,ad_org_id,isactive,created,createdby,updated,updatedby,name,locode,coordinates,postal,areacode,c_country_id,c_region_id,c_city_uu)
		 VALUES (nextid(56,'N'),'0','0','Y',statement_timestamp(),'100',statement_timestamp(),'100','阿勒泰地区','654300','\N','','\N','153',(SELECT max(c_region_id) FROM c_region where SUBSTRING(description,2,2) = '65'),generate_uuid());
END$$;