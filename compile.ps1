Write-Host "Compiling Java files..." -ForegroundColor Green
javac utils/InputUtils.java tut17.java 

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!" -ForegroundColor Green
    Write-Host "Running tut13..." -ForegroundColor Yellow
    java tut13
} else {
    Write-Host "Compilation failed!" -ForegroundColor Red
}
