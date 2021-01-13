<html>
<body>
<h2>Mail Form</h2>

<h3>${success}</h3>
<h3>${faild}</h3>
<form action="mail.do" method="post">
Reciver MailID:<input type="email" name="to"  placeholder="enter the emailId">
Subject :<input type="text" name="subject" placeholder="enter the subject">
Body: <input type="text" name="body" placeholder="enter your message">

<button type="submit">SEND</button>
</form>

</body>
</html>
