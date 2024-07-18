    document.addEventListener('alpine:init', () => {
        Alpine.data('app', () => ({
            orders: [],
            currentPage: 1,
            pageSize: 5,
            search: '',
            filteredOrders() {
                if (!this.search.trim()) {
                    return this.orders;
                }
                return this.orders.filter(product =>
                    product.description.toLowerCase().includes(this.search.toLowerCase()) ||
                    product.text.toLowerCase().includes(this.search.toLowerCase())
                );
            },
            init() {
                this.fetchOrders();
            },
            fetchOrders() {
                fetch('/web/api/orders/')
                    .then(response => response.json())
                    .then(data => {
                        this.orders = data;
                    })
                    .catch(error => {
                        console.error('Error fetching orders:', error);
                    });
            }
        }));
    });