<?PHP
$hostname_localhost ="localhost";
$database_localhost ="app_desarrollo";
$username_localhost ="root";
$password_localhost ="";

$json=array();

$idcategorias="*";
$nombre="*";
$cod_articulo="*";
$precio_venta="*";
$stock="*";
$estado="*";
$consultaPorRealizar=TRUE;

	
		
			if( isset($_GET["idcategorias"]) || isset($_GET["nombre"]) || isset($_GET["cod_articulo"])|| 
			isset($_GET["precio_venta"]) || isset($_GET["stock"])  || isset($_GET["estado"])  && $consultaPorRealizar){

			
				if(isset($_GET["idcategorias"])) {
					$idcategorias=($_GET['idcategorias']); 
				}

				if(isset($_GET["nombre"])) { 
					$nombre=($_GET['nombre']); 
				}

				if(isset($_GET["cod_articulo"])) { 
					$cod_articulo=($_GET['cod_articulo']); 
				}	
					
				if(isset($_GET["precio_venta"])) { 
					$precio_venta=($_GET['precio_venta']);
				}
				if (isset($_GET["stock"])) {
					$stock=($_GET['stock']);
				}
				if(isset($_GET["estado"])){

					$estado=($_GET['estado']);
				}
			
			
			
						
			$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

			$consulta="SELECT idarticulos,idcategorias,nombre,cod_articulo,precio_venta,stock,estado FROM articulos WHERE (idcategorias LIKE '%".$idcategorias."%' ) OR (nombre LIKE '%".$nombre."%' ) OR (cod_articulo LIKE '%".$cod_articulo."%' ) OR (precio_venta LIKE '%".$precio_venta."%' ) OR (stock LIKE '%".$stock."%' ) OR (estado LIKE '%".$estado."%' )";

			$resultado=mysqli_query($conexion,$consulta) or die("No se pudo conectar");
			
			while($registro=mysqli_fetch_array($resultado)){
				$json['articulos'][]=$registro;
				

			}
			mysqli_close($conexion);
			echo json_encode($json);
			$consultaPorRealizar =FALSE;

		//CONSULTA
		//http://localhost/servicioWeb/wsJSONConsultaPorArticulo2.php?cod_articulo=8&precio_venta=2&idcategorias=1&nombre=tt&estado=Activo&stock=0
		//http://localhost/servicioWeb/wsJSONConsultaPorArticulo2.php?cod_articulo=""&precio_venta=""&idcategorias=2&nombre=Bateria&estado=""&stock=""
		}


?>