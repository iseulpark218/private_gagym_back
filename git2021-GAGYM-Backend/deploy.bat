@rem ===== 1. 다른 프로젝트에서 할 때는 사전에 mkdir /home/ubuntu/app/프로젝트명 디렉터리를 만들어야함
@rem ===== 2. 키파일명을 맞추고 "gagym" 이것을 프로젝트명으로 바꿈

@rem ===== 1. 빌드된 jar파일을 서버에 전송
scp -i "C:\keys\gagymback.pem" -r ./build/libs/gagym*.jar ubuntu@ec2-3-36-96-181.ap-northeast-2.compute.amazonaws.com:/home/ubuntu/app/gagym
@rem ===== 2. 기존 프로세스 종료
ssh -i "C:\keys\gagymback.pem" ubuntu@ec2-3-36-96-181.ap-northeast-2.compute.amazonaws.com "pkill -9 -f java"
@rem ===== 3. dev프로필로 jar 파일 실행
ssh -i "C:\keys\gagymback.pem" ubuntu@ec2-3-36-96-181.ap-northeast-2.compute.amazonaws.com "cd /home/ubuntu/app/gagym; nohup java -Dspring.profiles.active=dev -jar gagym*.jar 1>gagym.log 2>&1 &"
