<?PHP
$hostname_localhost ="localhost";
$database_localhost ="app_desarrollo";
$username_localhost ="root";
$password_localhost ="";



$json=array();

	if(isset($_GET["idcategorias"]) && isset($_GET["nombre"]) && isset($_GET["cod_articulo"]) && 
		isset($_GET["precio_venta"]) &&  isset($_GET["stock"]) && isset($_GET["estado"]) ){

		$idcategorias=$_GET['idcategorias'];
		$nombre=($_GET['nombre']);
		$cod_articulo=$_GET['cod_articulo'];
		$precio_venta=($_GET['precio_venta']);
		$stock=($_GET['stock']);
		$estado=($_GET["estado"]);


		$conexion=mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost) or die("Error CONEXION");
		

		$insert="INSERT INTO articulos (idcategorias, nombre, cod_articulo, precio_venta, stock, estado) VALUES ('{$idcategorias}','{$nombre}','{$cod_articulo}','{$precio_venta}','{$stock}','{$estado}')";

		$resultado_insert=mysqli_query($conexion,$insert)or die("Erro INSERCION");
		
		if($resultado_insert){
			$consulta="SELECT * FROM articulos WHERE cod_articulo='{$cod_articulo}'";
			$resultado=mysqli_query($conexion,$consulta);
			
			if($registro=mysqli_fetch_array($resultado)){
				$json['articulo'][]=$registro;
			}
			mysqli_close($conexion);
			echo json_encode($json);

		}
		//EN caso no de  poder registrar
		else{
			$resulta["idcategorias"]=0;
			$resulta["nombre"]='No Registra';
			$resulta["cod_articulo"]=0;
			$resulta["precio_venta"]=0;
			$resulta["stock"]=0;
			$json['articulo'][]=$resulta;
			echo json_encode($json);
		}
		
	}
	else{
			//En caso de que no se pudo conectar a la bases de datos
			$resulta["idcategorias"]=0;
			$resulta["nombre"]='Ws No Retorna';
			$resulta["cod_articulo"]=0;
			$resulta["precio_venta"]=0;
			$resulta["stock"]=0;
			$json['articulo'][]=$resulta;
			echo json_encode($json);
		}


		/**
		 *
		  	if($resultado_insert){
			$consulta="SELECT * FROM articulos WHERE cod_articulo = '{$cod_articulo}'";
			$resultado=mysqli_query($conexion,$consulta);
			
			if($registro=mysqli_fetch_array($resultado)){
				$json['articulo'][]=$registro;
			}
			mysqli_close($conexion);
			echo json_encode($json);
		
		 */
//http://localhost/servicioWeb/wsJSONRegistrarArticulo.php?idcategorias=1&nombre=bateria&cod_articulo=2578&precio_venta=1500&stock=4&estado=Activo
//http://localhost/servicioWeb/wsJSONRegistrarArticulo.php?idcategorias=1&nombre=capo&cod_articulo=2579&precio_venta=1500&stock=4&estado=Activo

?>