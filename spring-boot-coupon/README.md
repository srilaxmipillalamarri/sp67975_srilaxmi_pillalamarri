This application demonstrates the Coupon service.

REST call details:

POST:

TO INSERT THE RECORD INTO COUPON ENTITY
https:localhost:1111/coupon-api/coupons
<CouponDto>
     <couponId>1</couponId>
     <couponCode>OFF30</couponCode>
     <expDate>july16th2022</expDate>
     <couponPrice>65</couponPrice>
     <couponDesc>30%OFF ON 65rs coupon</couponDesc>
</CouponDto>

GET :

1)TO GET THE COUPON DETAILS BASED ON ID
https://localhost:1111/coupon-api/coupons/{couponId}

2)TO GET ALL THE COUPON DETAILS
https://localhost:1111/coupon-api/coupons
As Paging and sorting concepts were added we can get the records based on the pagenumber, pagesize,sorting property (asc& desc).
https://localhost:1111/coupon-api/coupons/?pageNumber:=0&pageSize:=3&sortBy=couponPrice&dir=DESC
{Here we get records sorted based on couponPrice}
If we didnt mention those values then based on default values the records will be retrieved.

3)TO GET THE COUPON DETAILS BASED ON couponCode
https://localhost:1111/coupon-api/coupons/code/{couponCode}

4)TO GET THE COUPON DETAILS WHICH SATISFIES  BOTH COUPONCODE AND EXPDATE
https://localhost:1111/coupon-api/coupons/date/{couponCode}/{expDate}

5)TO GET THE COUPON DETAILS WHICH SATISFIES  ONE OF BOTH i.e., COUPONCODE OR COUPONPRICE
https://localhost:1111/coupon-api/coupons/{couponCode}/{couponPrice}

6)TO GET THE THE COUPON DETAILS HAVING THE COUPONCODE ORDERED BY COUPONPRICE
https://localhost:1111/coupon-api/coupons/order/{couponCode}

PUT:
TO UPDATE THE COUPON DETAILS
https://localhost:1111/coupon-api/coupons/{couponId}


DELETE:
TO DELETE THE RECORD FROM COUPON
https://localhost:1111/coupon-api/coupons/{couponId}


