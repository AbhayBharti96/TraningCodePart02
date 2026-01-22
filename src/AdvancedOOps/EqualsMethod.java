package AdvancedOOps;

class A {
    int x;

    A(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {

        // 1. Same reference check
        if (this == obj)
            return true;

        // 2. Null check
        if (obj == null)
            return false;

        // 3. Class check
        if (getClass() != obj.getClass())
            return false;

        // 4. Type casting
        A other = (A) obj;

        // 5. Value comparison
        return this.x == other.x;
    }

    @Override
    public int hashCode() {
        return x;
    }
}

public class EqualsMethod {

    public static void main(String[] args) {
        A a = new A(10);
        A b = new A(10);

        System.out.println(a);           // address-like output
        System.out.println(b);           // address-like output
        System.out.println(a.equals(b)); // true ✅
    }
}
