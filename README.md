## API 명세서 설계

- 자원(Resource): 일정(schedules)
- 행동(Method):

        GET /schedules/name/{userName} → 이름으로 조회, 없을시 전체 조회
        POST /schedules → 일정 추가
        GET /schedules/{scheduleId} → 특정 일정 조회
        PUT /schedules/{scheduleId} → 일정 수정
        DELETE /schedules/{scheduleId} → 일정 삭제

- 응답(Response): JSON 형식으로 설계

```jsx
{
    "title": "일정 제목",
    "contents": "일정 내용",
    "name": "작성자명",
    "password": "비밀번호"

}
```

## API 명세서

### 등록
- Request - 요청
- Method: POST
- URL: {{http://localhost:8080}}/schedules
- Content-Type: application/json
- Body:

```jsx
{
    "title": "일정 제목",
    "contents": "일정 내용",
    "name": "작성자명",
    "password": "비밀번호"

}
```

Response
- Status Code: 201 Created
- Body:

```jsx
{
"id": "AutoIncrement(Integer)",
"title": "{{$body 'title' ''}}",
"contents": "{{$body 'contents' ''}}",
"name": "{{$body 'name' ''}}",
"createdAt": {{$isoTimestamp}}
"modifiedAt": {{$isoTimestamp}}
}
```

### 전체 조회
- Request - 요청
- Method: GET
- URL: {{http://localhost:8080}}/schedules
Response
- Status Code: 200 OK
- Body:

```jsx
[
{
"id": "AutoIncrement(Integer)",
"title": "{{$body 'title' ''}}",
"contents": "{{$body 'contents' ''}}",
"name": "{{$body 'name' ''}}",
"createdAt": {{$isoTimestamp}}
"modifiedAt": {{$isoTimestamp}}
}
]
```

### 삭제
- Request - 요청
- Method: DELETE
- URL: {{http://localhost:8080}}/schedules/{id}
- Path Parameters:
키 : id / 값 : 1

Response
- Status Code: 200 OK

### 일정 수정
- Request - 요청
- Method: PUT
- URL: {{http://localhost:8080}}/schedules/{id}
- Path Parameters:
키 : id / 값 : 1
- Content-Type: application/json
- Body:

```jsx
{
"title": "일정 제목",
"name": "작성자명",
"password": "비밀번호"
}
```

Response

- Status Code: 200 OK
- Body:

```jsx
{
"id": "AutoIncrement(Integer)",
"title": "{{$body 'title' ''}}",
"name": "{{$body 'name' ''}}",
"modifiedAt": {{$isoTimestamp}}
}
```

### 특정 일정 조회
- Request - 요청
- Method: GET
- URL: {{http://localhost:8080}}/schedules/{id}
- Path Parameters:
키 : id / 값 : 1
- Response
- Status Code: 200 OK
- Body:

```jsx
{
"id": "AutoIncrement(Integer)",
"title": "{{$body 'title' ''}}",
"contents": "{{$body 'contents' ''}}",
"name": "{{$body 'name' ''}}",
"createdAt": {{$isoTimestamp}}
"modifiedAt": {{$isoTimestamp}},
"comments": [
	{
		"id": "AutoIncrement(Integer)",
		"contents": "{{$body 'contents' ''}}",
		"name": "{{$body 'name' ''}}",
		"createdAt": {{$isoTimestamp}}
		"modifiedAt": {{$isoTimestamp}}
		}
	]
}
```
