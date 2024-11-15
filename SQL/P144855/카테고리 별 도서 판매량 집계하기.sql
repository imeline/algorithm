select a.CATEGORY, sum(b.SALES) as TOTAL_SALES
from BOOK A
join BOOK_SALES B
on a.BOOK_ID = b.BOOK_ID
where b.SALES_DATE like '2022-01-%'
group by a.CATEGORY
order by a.CATEGORY
