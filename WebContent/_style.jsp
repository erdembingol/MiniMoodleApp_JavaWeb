<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">

.container {
	width: 406px;
	max-width: 406px;
	margin: auto;

    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
}

#signup {
	padding: 0px 25px 25px;
	background: #fff;
	box-shadow: 0px 0px 0px 5px rgba(255, 255, 255, 0.4), 0px 4px 20px
		rgba(0, 0, 0, 0.33);
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	display: table;
	position: static;
}

#signup .form_header {
	margin-bottom: 20px;
	margin-top: 20px;
}

#signup .form_header h3 {
	text-align: center;
	color: #333333;
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 5px;
}

#signup .form_header p {
	color: #8f8f8f;
	font-size: 14px;
	font-weight: 300;
}

#signup .sep {
	height: 1px;
	background: #e8e8e8;
	width: 415px;
	margin: 0px -25px;
}

#signup .inputs {
	margin-top: 25px;
	margin-left: 13px;
}

#signup .inputs label {
	color: #8f8f8f;
	font-size: 12px;
	font-weight: 300;
	letter-spacing: 1px;
	margin-bottom: 7px;
	display: block;
}

input::-webkit-input-placeholder {
	color: #b5b5b5;
}

input:-moz-placeholder {
	color: #b5b5b5;
}

#signup .inputs input[type=text], input[type=password], input[type=file] {
	background: #f5f5f5;
	font-size: 0.8rem;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	border: none;
	padding: 13px 10px;
	width: 330px;
	margin-bottom: 20px;
	box-shadow: inset 0px 2px 3px rgba(0, 0, 0, 0.1);
	clear: both;
}

#signup .inputs textarea {
	background: #f5f5f5;
	font-size: 1.1rem;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	border: none;
	padding: 13px 10px;
	width: 330px;
	margin-bottom: 20px;
	box-shadow: inset 0px 2px 3px rgba(0, 0, 0, 0.1);
	clear: both;
	resize: none;
}

#signup .inputs input[type=submit] {
	-moz-box-shadow: inset 0px 1px 3px 0px #276873;
	-webkit-box-shadow: inset 0px 1px 3px 0px #276873;
	box-shadow: inset 0px 1px 3px 0px #276873;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #599bb3
		), color-stop(1, #408c99));
	background: -moz-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -webkit-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -o-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -ms-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: linear-gradient(to bottom, #599bb3 5%, #408c99 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#599bb3',
		endColorstr='#408c99', GradientType=0);
	background-color: #599bb3;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	border: 1px solid #29668f;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 15px;
	font-weight: bold;
	padding: 14px 76px;
	width: 350px;
	text-decoration: none;
	text-shadow: 0px -1px 0px #32a9d1;
}

#signup .inputs input[type=text]:focus, input[type=password]:focus, input[type=file]:focus {
	background: #fff;
	box-shadow: 0px 0px 0px 3px #fff38e, inset 0px 2px 3px
		rgba(0, 0, 0, 0.2), 0px 5px 5px rgba(0, 0, 0, 0.15);
	outline: none;
}

#signup .inputs textarea:focus {
	background: #fff;
	box-shadow: 0px 0px 0px 3px #fff38e, inset 0px 2px 3px
		rgba(0, 0, 0, 0.2), 0px 5px 5px rgba(0, 0, 0, 0.15);
	outline: none;
}

#signup .inputs input[type=submit]:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #408c99
		), color-stop(1, #599bb3));
	background: -moz-linear-gradient(top, #408c99 5%, #599bb3 100%);
	background: -webkit-linear-gradient(top, #408c99 5%, #599bb3 100%);
	background: -o-linear-gradient(top, #408c99 5%, #599bb3 100%);
	background: -ms-linear-gradient(top, #408c99 5%, #599bb3 100%);
	background: linear-gradient(to bottom, #408c99 5%, #599bb3 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#408c99',
		endColorstr='#599bb3', GradientType=0);
	background-color: #408c99;
}

#signup .inputs input[type=submit]:active {
	position: relative;
	top: 1px;
}

#signup .inputs label.terms {
	float: left;
	font-size: 14px;
	font-style: italic;
}

.fileUpload {
	float: left;

}

.fileUpload input[type=submit] {
	-moz-box-shadow: inset 0px 1px 3px 0px #276873;
	-webkit-box-shadow: inset 0px 1px 3px 0px #276873;
	box-shadow: inset 0px 1px 3px 0px #276873;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #599bb3
		), color-stop(1, #408c99));
	background: -moz-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -webkit-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -o-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: -ms-linear-gradient(top, #599bb3 5%, #408c99 100%);
	background: linear-gradient(to bottom, #599bb3 5%, #408c99 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#599bb3',
		endColorstr='#408c99', GradientType=0);
	background-color: #599bb3;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	border: 1px solid #29668f;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: Arial;
	font-size: 10px;
	font-weight: bold;
	padding: 8px 20px;
	text-decoration: none;
	text-shadow: 0px -1px 0px #32a9d1;
}

.fileUpload input[type=file] {
	background: #f5f5f5;
	font-size: 0.8rem;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	border: none;
	padding: 4px 4px;
	width: 200px;
	box-shadow: inset 0px 2px 3px rgba(0, 0, 0, 0.1);
	
}

/*------------------------- Index Page ------------------------*/ 
.index{
	position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
}

.index ul{
	margin:0;
	list-style:none;
	padding:13px 0 0;
	float:right;
}

.index ul li{
	float:left;
	margin:0 0 0 63px;
}

.index ul li.selected a,.index ul li a:hover{
	color:#f78117;
}

.index ul li a{
	font-size:40px;
	text-decoration:none;
	color:#5e5e5e;
	font-family: 'RokkittRegular';
	outline:none;
	font-weight: bold;
}

.profile_image {
	width: 60px;
	float: right;
	margin-top: -15px;
	color: #006bb3;
}

.course a {
	font-weight: bold;
	outline:none;
	color:#636363;
}

.course a:hover{
	color:#f78117;
}

.new_c_p a{
	font-size:15px;
	font-weight: bold;
	outline:none;
	color:#636363;
}

.new_c_p a:hover{
	color:#f78117;
}

.seperator {
	background-image: url(/MiniMoodleApp/images/separator.jpg);
	height: 4px;
	margin:auto;
	width: 90%;
	margin-bottom: 20px;
}

/* Website template by freewebsitetemplates.com */
/*------------------------- Layout styles ------------------------*/ 
body{
	margin:0;
	background:url(/MiniMoodleApp/images/bg-body.jpg);
}
.page{}

/*------------------------- Font ------------------------*/ 
@font-face {
    font-family: 'RokkittRegular';
    src: url('rokkitt-regular-webfont.eot');
    src: url('rokkitt-regular-webfont.eot?#iefix') format('embedded-opentype'),
         url('rokkitt-regular-webfont.woff') format('woff'),
         url('rokkitt-regular-webfont.ttf') format('truetype'),
         url('rokkitt-regular-webfont.svg#RokkittRegular') format('svg');
    font-weight: normal;
    font-style: normal;
}

/*------------------------- Header ------------------------*/ 
.header{
 	background:url(/MiniMoodleApp/images/bg-footer.jpg) no-repeat center 120px;
	width:940px;
	margin:0 auto;
	height:105px;
	padding:36px 10px 0;
}
.header img{
	display:block;
	float:left;
	outline:none;
}
.header ul{
	margin:0;
	list-style:none;
	padding:13px 0 0;
	float:left;
}
.header ul li{
	float:left;
	margin:0 0 0 63px;
}
.header ul li.selected a,.header ul li a:hover{
	color:#f78117;
}
.header ul li a{
	font-size:16px;
	font-weight: bold;
	text-decoration:none;
	color:#5e5e5e;
	font-family: 'RokkittRegular';
	outline:none;
}

/*------------------------- Body ------------------------*/ 
.body{
	width:940px;
	margin:0 auto;
	padding:0 10px;
	overflow:hidden;
}
.body h3{
	font-family: 'RokkittRegular';
	font-size:16px;
	font-weight:bold;
	color:#636363;
	margin:15px 0 0;
	line-height:21px;
}
.body p{
	font-family: 'RokkittRegular';
	font-size:16px;
	text-align:justify;
	color:#636363;
	margin:0 0 20px;
	line-height:21px;
}
.body p a{
	outline:none;
	color:#636363;
}
.body ul{
	list-style:none;
    margin:0;
    padding:0;
	overflow:hidden;
}
.body ul li:first-child{
	background:none;
	padding:0 0 0px;
}
.body ul li{
	overflow:hidden;
	background:url(/MiniMoodleApp/images/separator.jpg) no-repeat center top;
	padding:20px 0;
}
.body ul li div{
	float:left;
	margin:0 0 0 0px;
}
.body ul li div h3{
	margin:0;
	font-size:20px;
	font-weight:bold;
	font-family: 'RokkittRegular';
	color:#f28220;
	line-height:22px;
}
.body ul li div p{
	line-height:22px;
	font-family: 'RokkittRegular';
	font-size:14px;
	color:#5D5D5D;
	padding:0 0 30px;
	margin:0;
}
.body ul div{
	padding:0 0 20px;
}

/*------------------------- Footer ------------------------*/ 
.footer{
	width: 90%;
	background:url(/MiniMoodleApp/images/bg-footer.jpg) no-repeat center top;
	padding:65px 10px 207px;
	margin:0 auto;
	overflow:hidden;
}
.footer ul{
	list-style:none;
	margin:0 0 0 60px;
	padding:0;
	overflow:hidden;
	float:left;
}
.footer ul li:first-child a{
	border:none;
	padding:0 6px 0 0;
}
.footer ul li{
	float:left;
}
.footer ul li a:hover{
	color:#F78117;
}
.footer ul li a{
	border-width: 1px;
	border-color:#5b5b5b;
	border-style: none none none solid;
	color:#5b5b5b;
	font-size:10px;
	font-family: Trebuchet MS;
	text-decoration:none;
	font-weight:bold;
	padding:0 6px;
	outline:none;
}
.footer p{
	color:#5b5b5b;
	font-size:10px;
	font-family: Trebuchet MS;
	font-weight:bold;
	float:left;
	margin:6px 0 0 135px;
}

</style>
</head>