<?php
    echo ("<script>setTimeout('window.location.reload()',500);</script>");
    header("Content-type: text/html; charset=utf-8");

    $con=mysqli_connect('localhost','root','Xkw134625134625');
    if(!$con){
    die('connect failed!');
    }else{
    echo "数据库连接成功！";
    }

    $selected = mysqli_select_db($con,"CanteenCalledSystem")
    or die("Could not select examples");  
    mysqli_query($con,"SET NAMES utf8");
    $result = mysqli_query($con,"SELECT * FROM number");
  

    echo "<table border='1'>
        <tr>
        <th>编号</th>
        <th>餐品名</th>
        <th>状态</th>
        </tr>";

    while($row = mysqli_fetch_array($result))
    {
        echo "<tr>";
        echo "<td>" . $row['number'] . "</td>";
        echo "<td>" . $row['food_name'] . "</td>";
        echo "<td>" . $row['status'] . "</td>";
    }
        echo "</table>";

    mysqli_close($con);          // 关闭 MySQL 连接。

?>