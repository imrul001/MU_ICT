<?php

 $year = $_POST['year'];
 $month = $_POST['month'];
 $day = $_POST['day'];	 

 $wsdl_url = "http://imrul-u30jc:8080/AgeProvider/AuthorService?wsdl";
 $AuthorService = new SoapClient($wsdl_url);
 $params = array (
            "arg0" => $year,
            "arg1" => $month,
            "arg2" => $day
            );
 $age = $AuthorService->__soapCall('getAgeByDateOfBirth', array($params));
 
 echo $age->return;
?>
