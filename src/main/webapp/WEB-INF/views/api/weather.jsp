<%@page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>weather.jsp</title>
</head>
<body>

       <script>
        function weather() {
            jQuery.ajax({
                url : "/api/weather",
                type : "GET",
                timeout : 30000,
                contentType : "application/json",
                dataType : "json",
                success : function (data, status, xhr) {
                    let dataHeader = data.result.response.header.resultCode;

                    if(dataHeader == "00") {
                        console.log("success == >");
                        console.log(data);
                    } else {
                        console.log("fail == >");
                        console.log(data);
                    };
                },

                error : function (e, status, xhr, data) {
                    console.log("error == >");
                    console.log(e);
                }
            });
        }
        
       
    </script>

</body>
</html>