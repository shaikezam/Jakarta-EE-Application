    document.addEventListener('alpine:init', () => {
        Alpine.data('app', () => ({
            products: [],
            currentPage: 1,
            pageSize: 5,
            search: '',
            filteredProducts() {
                if (!this.search.trim()) {
                    return this.products;
                }
                return this.products.filter(product =>
                    product.description.toLowerCase().includes(this.search.toLowerCase()) ||
                    product.text.toLowerCase().includes(this.search.toLowerCase())
                );
            },
            init() {
                this.fetchProducts();
            },
            fetchProducts() {
                fetch('/web/api/products')
                    .then(response => response.json())
                    .then(data => {
                        this.products = data;
                    })
                    .catch(error => {
                        console.error('Error fetching products:', error);
                    });
            }
        }));
    });