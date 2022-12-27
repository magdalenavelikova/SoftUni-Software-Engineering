package definingClasses.CarInfo;



    public class Car {
        private String brand;
        private String model;
        private int horsepower;

        public Car(String brand,String model,int horsepower){
            this.brand=brand;
            this.model=model;
            this.horsepower=horsepower;
        }
        public Car(String brand){
            this(brand,"unknown",-1);
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public int getHorsepower() {
            return horsepower;
        }



        @Override
        public String toString() {
            return "The car is: " +
                    brand + " " +
                    model + " - " + horsepower +
                    " HP.";
        }
    }


