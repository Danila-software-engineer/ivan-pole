package orders.appup_kw.ivanpole.models

import com.google.gson.annotations.SerializedName

data class Base (
    @SerializedName("category") val category : List<Category>?,
    @SerializedName("products") val products : List<Products>?,
    @SerializedName("on_page") val on_page : Int?,
    @SerializedName("page") val page : Int?,
)

data class Category (
    @SerializedName("ID") val iD : Int?,
    @SerializedName("NAME") val nAME : String?,
    @SerializedName("CODE") val cODE : String?,
    @SerializedName("DESCRIPTION") val dESCRIPTION : String?,
    @SerializedName("PICTURE") val pICTURE : String?,
    @SerializedName("ELEMENT_CNT") val eLEMENT_CNT : Int?,
    @SerializedName("SECTION_ID") val sECTION_ID : String?,
)

data class Products (
    @SerializedName("ID") val iD : Int?,
    @SerializedName("QUANTITY") val qUANTITY : Int?,
    @SerializedName("AVAILABLE") val aVAILABLE : String?,
    @SerializedName("WEIGHT") val wEIGHT : Int?,
    @SerializedName("TYPE") val tYPE : Int?,
    @SerializedName("QUANTITY_TRACE_ORIG") val qUANTITY_TRACE_ORIG : String?,
    @SerializedName("CAN_BUY_ZERO_ORIG") val cAN_BUY_ZERO_ORIG : String?,
    @SerializedName("SUBSCRIBE_ORIG") val sUBSCRIBE_ORIG : String?,
    @SerializedName("MEASURE_NAME") val mEASURE_NAME : String?,
    @SerializedName("MEASURE_RATIO") val mEASURE_RATIO : Int?,
    @SerializedName("PRICE") val pRICE : Double?,
    @SerializedName("DISCOUNT_PRICE") val dISCOUNT_PRICE : Double?,
    @SerializedName("CURRENCY") val cURRENCY : String?,
    @SerializedName("NAME") val nAME : String?,
    @SerializedName("PREVIEW_PICTURE") val pREVIEW_PICTURE : String?,
    @SerializedName("PREVIEW_TEXT") val pREVIEW_TEXT : String?,
    @SerializedName("DETAIL_PICTURE") val dETAIL_PICTURE : String?,
    @SerializedName("DETAIL_TEXT") val dETAIL_TEXT : String?,
    @SerializedName("CODE") val cODE : String?,
    @SerializedName("PROPERTIES") val pROPERTIES : Any
)

data class PROPERTIES (
    @SerializedName("ARTNUMBER") val aRTNUMBER : ARTNUMBER?
)

data class ARTNUMBER (
    @SerializedName("NAME") val nAME : String?,
    @SerializedName("DESCRIPTION") val dESCRIPTION : String?,
    @SerializedName("VALUE") val vALUE : Int?,
    @SerializedName("CODE") val cODE : String?,
)

data class Auth(
        @SerializedName("succes") val succes : Boolean,
        @SerializedName("error") val error : String? = null,
        @SerializedName("user") val user : Any? = null,
)

data class Basket (
        @SerializedName("count") val count : Int,
        @SerializedName("final_price") val final_price : Int,
        @SerializedName("weight") val weight : Int,
        @SerializedName("price") val price : Int,
        @SerializedName("products") val products : List<ProductsInBasket>
)

data class ProductsInBasket (
        @SerializedName("id") val id : Int,
        @SerializedName("name") val name : String,
        @SerializedName("quantity") val quantity : Int,
        @SerializedName("price") val price : Int,
        @SerializedName("final_price") val final_price : Int
)

data class UserResponse (
        @SerializedName("user") val user : User
)

data class User (
        @SerializedName("ID") val iD : Int,
        @SerializedName("TIMESTAMP_X") val tIMESTAMP_X : String,
        @SerializedName("LOGIN") val lOGIN : String,
        @SerializedName("PASSWORD") val pASSWORD : String,
        @SerializedName("CHECKWORD") val cHECKWORD : String,
        @SerializedName("ACTIVE") val aCTIVE : String,
        @SerializedName("NAME") val nAME : String,
        @SerializedName("LAST_NAME") val lAST_NAME : String,
        @SerializedName("EMAIL") val eMAIL : String,
        @SerializedName("LAST_LOGIN") val lAST_LOGIN : String,
        @SerializedName("DATE_REGISTER") val dATE_REGISTER : String,
        @SerializedName("LID") val lID : String,
        @SerializedName("PERSONAL_PROFESSION") val pERSONAL_PROFESSION : String,
        @SerializedName("PERSONAL_WWW") val pERSONAL_WWW : String,
        @SerializedName("PERSONAL_ICQ") val pERSONAL_ICQ : String,
        @SerializedName("PERSONAL_GENDER") val pERSONAL_GENDER : String,
        @SerializedName("PERSONAL_BIRTHDATE") val pERSONAL_BIRTHDATE : String,
        @SerializedName("PERSONAL_PHOTO") val pERSONAL_PHOTO : Int,
        @SerializedName("PERSONAL_PHONE") val pERSONAL_PHONE : String,
        @SerializedName("PERSONAL_FAX") val pERSONAL_FAX : String,
        @SerializedName("PERSONAL_MOBILE") val pERSONAL_MOBILE : String,
        @SerializedName("PERSONAL_PAGER") val pERSONAL_PAGER : String,
        @SerializedName("PERSONAL_STREET") val pERSONAL_STREET : String,
        @SerializedName("PERSONAL_MAILBOX") val pERSONAL_MAILBOX : String,
        @SerializedName("PERSONAL_CITY") val pERSONAL_CITY : String,
        @SerializedName("PERSONAL_STATE") val pERSONAL_STATE : String,
        @SerializedName("PERSONAL_ZIP") val pERSONAL_ZIP : Int,
        @SerializedName("PERSONAL_COUNTRY") val pERSONAL_COUNTRY : Int,
        @SerializedName("PERSONAL_NOTES") val pERSONAL_NOTES : String,
        @SerializedName("WORK_COMPANY") val wORK_COMPANY : String,
        @SerializedName("WORK_DEPARTMENT") val wORK_DEPARTMENT : String,
        @SerializedName("WORK_POSITION") val wORK_POSITION : String,
        @SerializedName("WORK_WWW") val wORK_WWW : String,
        @SerializedName("WORK_PHONE") val wORK_PHONE : String,
        @SerializedName("WORK_FAX") val wORK_FAX : String,
        @SerializedName("WORK_PAGER") val wORK_PAGER : String,
        @SerializedName("WORK_STREET") val wORK_STREET : String,
        @SerializedName("WORK_MAILBOX") val wORK_MAILBOX : String,
        @SerializedName("WORK_CITY") val wORK_CITY : String,
        @SerializedName("WORK_STATE") val wORK_STATE : String,
        @SerializedName("WORK_ZIP") val wORK_ZIP : String,
        @SerializedName("WORK_COUNTRY") val wORK_COUNTRY : String,
        @SerializedName("WORK_PROFILE") val wORK_PROFILE : String,
        @SerializedName("WORK_LOGO") val wORK_LOGO : String,
        @SerializedName("WORK_NOTES") val wORK_NOTES : String,
        @SerializedName("ADMIN_NOTES") val aDMIN_NOTES : String,
        @SerializedName("STORED_HASH") val sTORED_HASH : String,
        @SerializedName("XML_ID") val xML_ID : String,
        @SerializedName("PERSONAL_BIRTHDAY") val pERSONAL_BIRTHDAY : String,
        @SerializedName("EXTERNAL_AUTH_ID") val eXTERNAL_AUTH_ID : String,
        @SerializedName("CHECKWORD_TIME") val cHECKWORD_TIME : String,
        @SerializedName("SECOND_NAME") val sECOND_NAME : String,
        @SerializedName("CONFIRM_CODE") val cONFIRM_CODE : String,
        @SerializedName("LOGIN_ATTEMPTS") val lOGIN_ATTEMPTS : Int,
        @SerializedName("LAST_ACTIVITY_DATE") val lAST_ACTIVITY_DATE : String,
        @SerializedName("AUTO_TIME_ZONE") val aUTO_TIME_ZONE : String,
        @SerializedName("TIME_ZONE") val tIME_ZONE : String,
        @SerializedName("TIME_ZONE_OFFSET") val tIME_ZONE_OFFSET : String,
        @SerializedName("TITLE") val tITLE : String,
        @SerializedName("BX_USER_ID") val bX_USER_ID : String,
        @SerializedName("LANGUAGE_ID") val lANGUAGE_ID : String,
        @SerializedName("BLOCKED") val bLOCKED : String,
        @SerializedName("IS_ONLINE") val iS_ONLINE : String
)