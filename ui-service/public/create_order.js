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
                fetch('/web/api/products/')
                    .then(response => response.json())
                    .then(data => {
                        this.products = data;
                    })
                    .catch(error => {
                        console.error('Error fetching products:', error);
                    });
            },
            buy() {
                let orderDTO = {
                    price: 0,
                    orderProducts: []
                };
                let cursor = 0;
                for(let i = 0; i < this.products.length; i++) {
                    const productName = this.products[i].name;
                    const productId = this.products[i].id;
                    const price = this.products[i].price;
                    const quantity = this.quantities[i];
                    if (quantity > 0) {
                        orderDTO.orderProducts[cursor] = {};
                        orderDTO.orderProducts[cursor].productId = productId;
                        orderDTO.orderProducts[cursor].productName = productName;
                        orderDTO.orderProducts[cursor].quantity = quantity;
                        console.log(`Product ID: ${productId}, Quantity: ${quantity}`);
                        orderDTO.price += (quantity * price)
                        cursor++;
                       }
                    }
                    if (orderDTO.price > 0) {
                        console.log(orderDTO);
                        orderDTO.userId = 1;
                        fetch('/web/api/orders/', {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify(orderDTO),
                        })
                        .then(
                            data => { window.location.reload();
                        })
                    }
                }
        }));
    });