package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
         //Abreviasion para el avance del robot
        public static void avanzar(int a){
            for (int i = 0; i < a; i++) {
                estudiante.move();
            }
        }
        
        //Abreviación para que Karel gire
        public static void girar(int a){
            for (int i = 0; i < a; i++) {
                estudiante.turnLeft();
            }
        }
        
        
        public static int procedimiento(){
            avanzar(1);
            
            //separar en grupos
            if(estudiante.canPickThing()){
                //quedan el 0 - 2 - 3 - 5 - 6 - 8 - 9
                avanzar(2);
                
                //Determinar si es cero
                if(estudiante.canPickThing()){
                    avanzar(1);
                    girar(1);
                    avanzar(1);
                    
                    //Determinar si es (2,3) o (8,6,5,9)
                    if(estudiante.canPickThing()){
                        girar(1);
                        avanzar(2);
                        
                        //Determinar si es (8,6) o (5,9)
                        if(estudiante.canPickThing()){
                            girar(2);
                            avanzar(2);
                            girar(3);
                            avanzar(2);
                            
                            //Determinar si es 8 o 6
                            if(estudiante.canPickThing()){
                                girar(2);
                                avanzar(1);
                                girar(1);
                                avanzar(4);
                                System.out.print("8 \n");
                                return 8;
                            
                            }else{
                                girar(2);
                                avanzar(1);
                                girar(1);
                                avanzar(4);
                                System.out.print("6 \n");
                                return 6;
                            }
                            
                        }else{
                            girar(2);
                            avanzar(2);
                            girar(3);
                            avanzar(2);
                            
                            //Determinar si es 9 o 5
                            if(estudiante.canPickThing()){
                                girar(2);
                                avanzar(1);
                                girar(1);
                                avanzar(4);
                                System.out.print("9 \n");
                                return 9;
                            
                            }else{
                                girar(2);
                                avanzar(1);
                                girar(1);
                                avanzar(4);;
                                System.out.print("5 \n");
                                return 5;
                            }
                        }
                        
                    }else{
                        girar(1);
                        avanzar(2);
                        
                        //Determinar si es 2 o 3
                        if(estudiante.canPickThing()){
                            girar(1);
                            avanzar(1);
                            girar(3);
                            avanzar(2);
                            System.out.print("2 \n");
                            return 2;
                        }else{
                            girar(1);
                            avanzar(1);
                            girar(3);
                            avanzar(2);
                            System.out.print("3 \n");
                            return 3;
                        }
                    }
                            
                }else{
                    girar(2);
                    avanzar(3);
                    System.out.print("0 \n");
                    return 0;
                }
                
                
            }else{
                
                //quedan el 1 - 4 - 7 
                avanzar(2);
                
                //Determinar si es 4
                if(estudiante.canPickThing()){
                    girar(2);
                    avanzar(3);
                    System.out.print("4 \n");
                    return 4;
                  
                }else{
                    avanzar(2);
                    
                    //Determianr si es 1 o 7
                    if(estudiante.canPickThing()){
                        girar(2);
                        avanzar(5);
                        System.out.print("7 \n");
                        return 7;
                    }else{
                        girar(2);
                        avanzar(5);
                        System.out.print("1 \n");
                        return 1;
                    }
                }
            }
        }
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,6,2, Direction.NORTH,10);
            
            procedimiento();
            girar(1);
            avanzar(3);
            girar(1);
            procedimiento();
            girar(1);
            avanzar(3);
            girar(1);
            procedimiento();
            
               
  
	}
}

