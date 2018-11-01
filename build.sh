rm -fr springcloud
git clone https://github.com/kongq1983/springcloud.git
cd springcloud
mvn clean install
echo "-------------------------------start docker-compose--------------------------------------"

#docker-compose up


BASE_PATH=/springcloud

cd $BASE_PATH/springcloud/eureka

echo "-------------------------------start--build--eureka---docker-----------------------------"

docker build -t 192.168.1.148:5000/eurake:1.0.5 .

