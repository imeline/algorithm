select c.CAR_ID, c.CAR_TYPE, round(30 * c.DAILY_FEE * (1 - p.DISCOUNT_RATE / 100)) as FEE
                                    
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.CAR_TYPE = p.CAR_TYPE
                                    
where c.CAR_TYPE in ('세단', 'SUV') 
    and c.CAR_ID not in (
        select distinct CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01'
        ) 
    and p.DURATION_TYPE = '30일 이상'
    and round(30 * c.DAILY_FEE * (1 - p.DISCOUNT_RATE / 100)) between 500000 and 1999999
                                    
order by FEE desc, CAR_TYPE, CAR_ID desc
