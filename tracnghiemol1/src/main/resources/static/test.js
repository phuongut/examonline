	
        // Đảm bảo rằng bạn đã bao quanh mã của mình trong một hàm hoặc blok {} để tránh xung đột biến toàn cục
(function () {
    // Khai báo ứng dụng AngularJS
   var app = angular.module("myapp", ['ngSanitize']);
    app.controller("myctrl", function ($scope) {
        // Gán dữ liệu người dùng cho $scope
        
        $scope.users = usersData;

        // Khởi tạo các biến và hàm điều khiển khác nếu cần
        $scope.showExplanation = false;
        $scope.showExplanationnd = false;
        $scope.submitButtonVisible = false;
        
         /* angular.forEach($scope.users, function (sv, index) {
            sv.questionNumber = index + 1; // Số thứ tự bắt đầu từ 1*/
        //});
       /* console.log(questionNumber)*/
        



       $scope.check = function () {
            var count = 0;
            angular.forEach($scope.users, function (sv) {
                if (sv.selectedAnswer === sv.kq) {
                    count++;
                } else {
                    sv.isWrong = true;
                }
                $scope.showExplanation = true;
                $scope.showExplanationnd = true;
                sv.isUserAnswer = sv.selectedAnswer;
                $scope.submitButtonVisible = true;
            });

            alert("You got " + count + " marks");
            angular.forEach($scope.users, function (sv) {
                angular.forEach(sv.Answers, function (ans) {
                    if (ans.value === sv.kq) {
                        ans.isCorrect = true;
                    }
                });
            });
        };
        
        $scope.exit = function (){
			const localhostAddress = "http://localhost:1602/index"; // Thay thế 3000 bằng số cổng bạn đang sử dụng

window.location.href = localhostAddress;
		}
        
        
        
      /*var easyQuestions = usersData.filter(function(question) {
    return question.cb === 2;
});

var hardQuestions = usersData.filter(function(question) {
    return question.cb === 1;
});

// Lấy ngẫu nhiên 1 câu hỏi dễ và 4 câu hỏi khó
var randomEasyQuestion = easyQuestions[Math.floor(Math.random() * easyQuestions.length)];
var randomHardQuestions = [];
while (randomHardQuestions.length < 10) {
    var randomHardQuestion = hardQuestions[Math.floor(Math.random() * hardQuestions.length)];
    if (!randomHardQuestions.includes(randomHardQuestion)) {
        randomHardQuestions.push(randomHardQuestion);
    }
}

// Gộp câu hỏi dễ và câu hỏi khó để hiển thị trên trang web
$scope.filteredQuestions = [randomEasyQuestion, ...randomHardQuestions];*/
        
   
    });
})();

