<?PHP
$hostname_localhost ="localhost";
$database_localhost ="app_desarrollo";
$username_localhost ="root";
$password_localhost ="";

$json=array();
				
		$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

		$consulta="SELECT idarticulos,idcategorias,nombre,cod_articulo,precio_venta,stock,estado FROM articulos";
		$resultado=mysqli_query($conexion,$consulta);
		
		while($registro=mysqli_fetch_array($resultado)){
			$json['articulos'][]=$registro;
			
			//echo $registro['idarticulos'].' - '.$registro['nombre'].'<br/>';
			/*
			echo"id articulos: "	.$registro['idarticulos'];	echo"<br/>";
			echo"id categorias: "	.$registro['idcategorias'];	echo"<br/>";
			echo"nombre: "			.$registro['nombre'];		echo"<br/>";
			echo"cod_articulo: "	.$registro['cod_articulo'];	echo"<br/>";
			echo"precio_venta: "	.$registro['precio_venta'];	echo"<br/>";
			echo"stock: "			.$registro['stock'];		echo"<br/>";
			echo"estado: "			.$registro['estado'];		echo"<br/>";
			echo "--------------------------------------------------------------";echo"<br/>";
			*/
		}
		mysqli_close($conexion);
		echo json_encode($json);
?>