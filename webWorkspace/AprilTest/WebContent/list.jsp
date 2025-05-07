<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="java.util.List, com.mvc.model.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <style>
        @font-face {
            font-family: 'NanumSquareNeo-Variable';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-R@1.0/NanumSquareNeo-Variable.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }

        body {
            font-family: 'NanumSquareNeo-Variable', sans-serif;
            background-color: #f9f9f9; 
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            width: 90%;
            max-width: 1000px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            padding: 40px;
            margin: 40px;
        }

        h2 {
            color: #2c3e50; 
            font-size: 2.2rem;
            margin-bottom: 30px;
            text-align: center;
        }

        .search-box {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            flex-wrap: wrap;
            gap: 15px;
        }

        .search-box form {
            display: flex;
            gap: 10px;
        }

        .search-box input[type="text"] {
            padding: 10px 12px;
            border: 1px solid #ddd; 
            border-radius: 4px;
            width: 250px;
            font-size: 1rem;
        }

        .search-box input[type="submit"] {
            background-color: #3498db; 
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 10px 15px;
            cursor: pointer;
            font-size: 1rem;
            transition: background-color 0.2s ease-in-out;
        }

        .search-box input[type="submit"]:hover {
            background-color: #2980b9;
        }

        .write-btn a {
            background-color: #2ecc71; 
            color: #fff;
            padding: 10px 15px;
            border-radius: 4px;
            font-weight: 500;
            text-decoration: none;
            transition: background-color 0.2s ease-in-out;
        }

        .write-btn a:hover {
            background-color: #27ae60;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            border-spacing: 0; 
        }

        thead th {
            background-color: #f2f2f2; 
            color: #333;
            font-weight: 500;
            padding: 12px 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        tbody td {
            padding: 10px 10px;
            text-align: center;
            border-bottom: 1px solid #eee;
        }

        tbody tr:last-child td {
            border-bottom: none;
        }

        tbody tr:hover {
            background-color: #f5f5f5;
            transition: background-color 0.1s ease-in-out;
        }

        tbody td a {
            color: #333;
            text-decoration: none;
            transition: color 0.1s ease-in-out;
        }

        tbody td a:hover {
            color: #3498db;
        }

        .pagination {
            text-align: center;
            margin-top: 30px;
        }

        .pagination a {
            display: inline-block;
            margin: 0 5px;
            padding: 8px 12px;
            background-color: #eee;
            color: #555;
            border-radius: 4px;
            text-decoration: none;
            font-size: 0.9rem;
            transition: background-color 0.2s ease-in-out, color 0.2s ease-in-out;
        }

        .pagination a.active {
            background-color: #3498db;
            color: #fff;
            font-weight: 500;
        }

        .pagination a.arrow {
            font-size: 1rem;
            padding: 8px 14px;
        }

        .pagination a:hover {
            background-color: #3498db;
            color: #fff;
        }
    </style>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2>게시판</h2>

        <div class="search-box">
            <form method="get" action="<%=request.getContextPath()%>/list">
                <input type="text" name="keyword"
                    value="<%=request.getAttribute("keyword") != null ? request.getAttribute("keyword") : ""%>"
                    placeholder="검색어를 입력하세요">
                <input type="submit" value="검색">
            </form>
            <div class="write-btn">
                <a href="add">글쓰기</a>
            </div>
        </div>

        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<BoardDto> boardList = (List<BoardDto>) request.getAttribute("boardList");
                int currentPage = (Integer) request.getAttribute("currentPage");
                int totalPages = (Integer) request.getAttribute("totalPages");
            %>
            <%
                if (boardList != null && !boardList.isEmpty()) {
                    for (BoardDto board : boardList) {
            %>
                <tr>
                    <td><%=board.getId()%></td>
                    <td style="text-align: left;">
                        <a href="detail?id=<%=board.getId()%>">
                            <%
                                int depth = board.getDepth();

                                for (int i = 0; i < depth; i++) {
                                    out.print("&nbsp;&nbsp;&nbsp;&nbsp;");
                                }
                                if (depth > 0) {
                                    out.print("↳ ");
                                }
                            %>
                            <%=board.getTitle()%>
                        </a>
                    </td>
                    <td><%=board.getUserId()%></td>
                    <td><%=board.getCreatedAt()%></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr><td colspan="4" style="text-align: center;">게시글이 없습니다.</td></tr>
            <%
                }
            %>
            </tbody>
        </table>

        <div class="pagination">
            <%
                int prevPage = currentPage - 1 > 0 ? currentPage - 1: 1;
                int nextPage = currentPage + 1 <= totalPages ? currentPage + 1 : totalPages;

                int pageGroupSize = 10;
                int startPage = ((currentPage - 1) / pageGroupSize) * pageGroupSize + 1;
                int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

                int prevGroup = startPage - 1 > 0 ? startPage - 1 : 1;
                int nextGroup = endPage + 1 <= totalPages ? endPage + 1 : totalPages;
            %>

            <%
                if (startPage > 1) {
            %>
            <a class="arrow" href="?page=<%=prevGroup%>&keyword=<%=request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>">&lt;</a>
            <%
                }
            %>

            <%
                for (int i = startPage; i <= endPage; i++) {
                    if (i == currentPage) {
            %>
            <a class="active" href="?page=<%=i%>&keyword=<%=request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>"><%=i%></a>
            <%
                    } else {
            %>
            <a href="?page=<%=i%>&keyword=<%=request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>"><%=i%></a>
            <%
                    }
                }
            %>

            <%
                if (endPage < totalPages) {
            %>
            <a class="arrow" href="?page=<%=nextGroup%>&keyword=<%=request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>">&gt;</a>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>