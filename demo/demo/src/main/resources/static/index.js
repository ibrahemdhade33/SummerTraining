function getdata(){
httpReq = "http://localhost:9000/aaa/allEmployees"
Req =new  XMLHttpRequest()
Req.open("GET",httpReq)
Req.send()
}