int main()
{
    fact(); 
    a(); 
}

float fact(int n) {
    print(n); 
    if(n==0) {
        return 1;
    } 
    return n * fact(n - 1); 
}

void a() {
    int x = b(); 
    if (false) {
        c(); 
        d();
    }
}

void b() {
    c();
}

void c() {
    d();
}

void d() {
    
}

void e() {

}
