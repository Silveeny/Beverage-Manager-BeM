<%@ page import="java.util.List" %>
<html>
    <head>
		<!--
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		-->
		<link rel="stylesheet" href="style.css">
        <link href='https://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet'>
        <style>
        body {
            font-family: 'Open Sans';font-size: 14px;
        }
    </style>
	</head>
    <body class="body">
      <div class="header">
        <a href="https://www.info.uaic.ro/" class="logo logo-iamge"><img src="https://i.imgur.com/dbDeOMz.png" alt="FII" style="width:250px;height:60px;"></a>
        <div class="logo header-right">
          <a class="logo header-right" href="https://bemwadeblog.wordpress.com/">Project Site</a>
        </div>
      </div>
        <h1 class = "text-line">BEM - Beverage Ontology Manager - Search for a Drink</h1>
        <div id="account">

        </div>

        <div id="auth">
            Username: <input type="text" id="username" /> <br/>
            Password <input type="password" id="password" /> <br/>
            <button type="button" class="btn btn-primary" id="login">
                <i class="fas fa-search">Login</i>
            </button>
        </div>

        <form action="" id="first-form">


            <div class="input-group">
                <div class="form-outline">
                    <input type="search" id="search-bar" class="form-control" placeholder="Search for something"/>
                </div>

                <button type="button" class="btn btn-primary" id="search">
                    <i class="fas fa-search">search</i>
                </button>
            </div>


            <div id="master-select">

                <div>
                    <b> Countries </b> <br/>
                    <select class="form-select" id="country" multiple >
                        <%
                            List<String> countries = (List<String>) request.getAttribute("desCountries");
                            for (String country : countries) {
                        %>
                          <option value="<%= country %>"><%= country %></option>
                        <% } %>
                    </select>
                </div>

                <div>

                    <b> Ingredients </b> <br/>
                    <select class="form-select" id="ingredients" multiple aria-label="multiple">
                        <%
                            List<String> ingredients = (List<String>) request.getAttribute("desIngredients");
                            for (String ingredient : ingredients) {
                        %>
                          <option value="<%= ingredient %>"><%= ingredient %></option>
                        <% } %>
                    </select>

                </div>



                <div>
                    <b> Events </b> <br/>
                    <select class="form-select" id="events" multiple aria-label="multiple">
                        <%
                            List<String> events = (List<String>) request.getAttribute("desEvents");
                            for (String event : events) {
                        %>
                          <option value="<%= event %>"><%= event %></option>
                        <% } %>
                    </select>


                </div>


                <div>

                    <b> Restrictions </b> <br/>
                    <select class="form-select" id="restrictions" multiple aria-label="multiple">
                        <%
                            List<String> restrictions = (List<String>) request.getAttribute("desRestrictions");
                            for (String restriction : restrictions) {
                        %>
                          <option value="<%= restriction %>"><%= restriction %></option>
                        <% } %>
                    </select>
                </div>

            </div>


        </form>
		
		<div class="text-line">
             <p>Other Links:</p>
        </div>
		
        <button type="button" class="btn btn-primary drink-btn" aria-label="Left Align" id="all-carbonated-drinks">
            <center><img width="30%" height="50%" src="https://i.imgur.com/g6yRsSV.png" align="center"></center>

            <center>Carbonated Drinks</center>
        </button>

        <button type="button" class="btn btn-primary drink-btn" aria-label="Left Align" id="all-mocktails">
            <center><img width="30%" height="50%" src="https://i.imgur.com/z2685mx.png" align="center"></center>

            <center>Mocktails</center>
        </button>

        <button type="button" class="btn btn-primary drink-btn" aria-label="Left Align" id="all-coffee">
            <center><img width="30%" height="50%" src="https://i.imgur.com/u9fBEe2.png" align="center"></center>

            <center>Coffee</center>
        </button>

        <button type="button" class="btn btn-primary drink-btn" aria-label="Left Align" id="all-tea">
            <center><img width="30%" height="50%" src="https://i.imgur.com/pfnKjLV.png" align="center"></center>

            <center>Tea</center>
        </button>

        <div id="results-area">

        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<%--        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>--%>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
       <script type="text/javascript" src="resources/main.js"></script>
    </body>

</html>