<%-- 
    Document   : index
    Created on : Feb 3, 2015, 7:50:57 PM
    Author     : imrul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>jQuery UI Datepicker - Display multiple months</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="<c:url value="css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="css/jquery-ui.css"/>"/>
        <script type="text/javascript" src="<c:url value="js/jquery-1.11.0.js"/>"></script>
        <script type="text/javascript" src="<c:url value="js/jquery-ui.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="js/jquery.form.js"/>"></script>
        <script type="text/javascript" src="<c:url value="js/bootstrap.min.js"/>"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({
                    changeMonth: true,
                    changeYear: true,
                    maxDate: '-20Y'
                });
            });
        </script>
        <style>
            .errorMsg{
                color: red;
                font-weight: bold;
            }
            .successMsg{
                color: green;
                font-weight: bold;
            }
        </style>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#singlebutton").on("click", function () {
                    $('.modal-body').html("");
                    $('#myModalLabel').html("");
                    var age = $("#datepicker").val().trim();
                    if (age == "") {
                        $('.modal').modal('show');
                        $('#myModalLabel').html("Login Failed");
                        $('.modal-body').html("<p class='errorMsg'>Invalid Email or Password.</p>");
                        return false;
                    } else {
                        var url = "./AgeClient";
                        $.ajax({
                            type: "POST",
                            url: url,
                            data: $('#dateForm').serialize(),
                            success: function (data) {
                                if (data != "") {
                                    $('.modal').modal('show');
                                    $('#myModalLabel').html("Age Calculation");
                                    $('.modal-body').html("<p class='successMsg'>Your Age: " + data + " years.</p>");
                                }
                            }
                        });
                        return false;
                    }
                });
            })
        </script>

    </head>
    <body>
        <div style="width: 40%; height: auto; border: 1px solid #ddd; margin: 10% auto; padding: 1%;">  
            <div>   
                <form class="form-horizontal" id="dateForm" method="post" action="#">
                    <fieldset>
                        <!-- Form Name -->
                        <legend>Age Calculator</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="dob">Date of Birth</label>  
                            <div class="col-md-5">
                                <input id="datepicker" name="dob" type="text" placeholder="Enter your Date of birth" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="singlebutton">Single Button</label>
                            <div class="col-md-4">
                                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>