 -- ======================================== 临时表重跑数据 ========================================
rename table data_realse.product_comment to data_realse.product_comment_old;

rename table data_realse.product_comment_new to data_realse.product_comment;

#初始化 把old改为new 再清空数据
rename table data_realse.product_comment_old to data_realse.product_comment_new;

-- 展示建表
show create table dws_all_db.dws_foo_6_order_wide_table_centre;

-- 使用数据库
use data_realse;

select * from data_realse.product_comment limit 10;

-- 去除前后空格
select trim (' ff cc gf ');
 -- ======================================== 表数据验证 ========================================
SELECT count(1),statDate FROM data_realse.bi_comment_content_detail
GROUP BY pdate = '2020-08-01'
order by statDate

SELECT productName
FROM data_realse.product_comment
where productName like '%餐%' and statDate>='2021-02-18'

SELECT statDate,uniteStoreId,storeName,fromType,commentContent,commentType FROM data_realse.bi_comment_content_detail 
where  statDate = '2021-03-08'
and length(commentContent)<2 
and commentType='其他';

select substring(commentTime,1,10) as dd, platformKey,fromType,count(1)
from ods_foo_6_db.ods_externalcomment where pdate >= '2021-06-12'
and platformKey in ('8f777e45850dbb37','15fbe054f4b2fd5b') and  dataSource = '标准6.0'
group by dd, platformKey,fromType
order by dd, platformKey,fromType;

select statDate,platformKey,count(1) from data_realse.ordercommentstat
where  statDate >= '2021-06-12'
and platformKey in ('8f777e45850dbb37','15fbe054f4b2fd5b')
group by statDate, platformKey
order by statDate, platformKey;

select statDate,fromType,sum(commentnum)
from orderCommentstat
where statDate >= '2021-06-15' and platformKey in ('8f777e45850dbb37','15fbe054f4b2fd5b') 
group by statDate,fromType
order by statDate,fromType;


 -- ======================================== 配置 ========================================
 -- 查看mysql字符集配置
show variables like '%char%';
