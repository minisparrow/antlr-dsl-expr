wget https://www.antlr.org/download/antlr4-cpp-runtime-4.13.1-source.zip
mkdir -p antlr4-cpp-runtime
mv ./antlr4-cpp-runtime-4.13.1-source.zip ./antlr4-cpp-runtime
cd antlr4-cpp-runtime
unzip antlr4-cpp-runtime-4.13.1-source.zip

mkdir -p build
mkdir -p run
cd build && cmake .. && make -j20
DESTDIR=../run make install

cd ../run/
sudo cp ./usr/local/include/antlr4-runtime /usr/local/include -rf
sudo cp ./usr/local/lib/* /usr/local/lib/ -rf

